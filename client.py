import pygame
import socket
import threading

# Server Configuration
HOST = '127.0.0.1'  # Change this to the server's IP address
PORT = 8080  # Port the server is listening on

# Initialize Pygame
pygame.init()
WIDTH, HEIGHT = 1400, 800
screen = pygame.display.set_mode((WIDTH, HEIGHT))
pygame.display.set_caption('Wordsprint Showdown! - Player')
font = pygame.font.Font(None, 30)

# Networking setup
client_socket = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
client_socket.connect((HOST, PORT))


def receive_messages():
    global active_string, life
    while True:
        try:
            message = client_socket.recv(1024).decode('utf-8')
            if message.startswith("UPDATE_STRING:"):
                active_string = message.split(":")[1]
            elif message.startswith("UPDATE_LIFE:"):
                life = int(message.split(":")[1])
        except:
            print("Connection lost.")
            client_socket.close()
            break


def send_message(message):
    client_socket.send(message.encode('utf-8'))


# Game variables
active_string = "P1 Tank"
life = 200

# Start receiving messages in a separate thread
threading.Thread(target=receive_messages, daemon=True).start()

# Main game loop
run = True
while run:
    for event in pygame.event.get():
        if event.type == pygame.QUIT:
            run = False
        elif event.type == pygame.KEYDOWN:
            if event.key == pygame.K_q:  # Example action, pressing 'q' sends a message
                send_message("UPDATE_STRING:Player pressed Q")
            elif event.key == pygame.K_w:  # Another action, pressing 'w' updates life
                send_message(f"UPDATE_LIFE:{life - 10}")

    screen.fill((0, 0, 0))  # Clear screen
    text_surface = font.render(active_string, True, (255, 255, 255))
    screen.blit(text_surface,
                (WIDTH // 2 - text_surface.get_width() // 2, HEIGHT // 2 - text_surface.get_height() // 2))

    pygame.display.flip()

pygame.quit()
client_socket.close()
