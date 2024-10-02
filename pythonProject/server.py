import socket
import threading
import pickle


def get_local_ip():
    try:
        # Connect to an external server to find out the local IP address
        s = socket.socket(socket.AF_INET, socket.SOCK_DGRAM)
        s.settimeout(0)
        s.connect(('8.8.8.8', 80))
        local_ip = s.getsockname()[0]
        s.close()
    except Exception as e:
        print(f"Error determining local IP address: {e}")
        local_ip = '192.168.1.10'  # Fallback to localhost
    return local_ip

# Define the server details
SERVER_IP = get_local_ip()  # Use dynamically obtained IP address
PORT = 5555
ADDR = (SERVER_IP, PORT)

# Create a socket object
server = socket.socket(socket.AF_INET, socket.SOCK_STREAM)

try:
    server.bind(ADDR)
    server.listen()
    print(f"Server is running on {SERVER_IP}:{PORT}")
except Exception as e:
    print(f"Error starting server: {e}")
    exit(1)

# Store connected clients
clients = []

# Game state
game_state = {
    'word': '',
    'player1_life': 200,
    'player2_life': 200
}

def broadcast_game_state():

    data = pickle.dumps(game_state)
    for client in clients:
        try:
            client.send(data)
        except Exception as e:
            print(f"Error sending data to client: {e}")
            clients.remove(client)

def handle_client(conn, addr):
    print(f"New connection: {addr}")
    clients.append(conn)

    while True:
        try:
            data = conn.recv(4096)
            if not data:
                print(f"Connection closed by {addr}")
                break

            # Handle incoming data
            updated_state = pickle.loads(data)
            if isinstance(updated_state, dict):
                global game_state
                game_state.update(updated_state)
                broadcast_game_state()
        except Exception as e:
            print(f"Error handling data from {addr}: {e}")
            break

    # Remove client from the list
    clients.remove(conn)
    conn.close()

def start_server():
    print("Server is starting...")
    while True:
        conn, addr = server.accept()
        thread = threading.Thread(target=handle_client, args=(conn, addr))
        thread.start()

def stop_server():

    for client in clients:
        client.close()
    server.close()

if __name__ == "__main__":
    try:
        start_server()
    except KeyboardInterrupt:
        print("Server shutting down...")
        stop_server()
