import pygame
import socket
import threading
import pickle
import random
import time

# Define the server details
SERVER_IP = '192.168.1.10'
PORT = 5555
ADDR = (SERVER_IP, PORT)

# Create a socket object
client = socket.socket(socket.AF_INET, socket.SOCK_STREAM)

try:
    client.connect(ADDR)
except ConnectionRefusedError:
    print(f"Failed to connect to {SERVER_IP}:{PORT}. Is the server running?")
    exit(1)
except Exception as e:
    print(f"Error connecting to server: {e}")
    exit(1)

# Initialize Pygame
pygame.init()
pygame.mixer.init()

pygame.mixer.music.load('bg music.wav')
pygame.mixer.music.play(1)

# Game variables
active_string = "Game Start"
life = 200
life2 = 200
countdown_started = False
change_interval = 4000  # Duration between word changes in milliseconds

# Text input variables
input_text_p1 = ""
input_text_p2 = ""
input_rect_p1 = pygame.Rect(50, 550, 300, 70)
input_rect_p2 = pygame.Rect(1040, 550, 300, 70)
input_active_p1 = False
input_active_p2 = False
font = pygame.font.Font('Pixel Coleco.otf', 30)
base_font = pygame.font.Font('Pixel Coleco.otf', 30)

def receive_data():
    global active_string, life, life2
    while True:
        try:
            data = client.recv(4096)
            if not data:
                print("No data received or connection closed")
                break

            try:
                game_state = pickle.loads(data)
                if isinstance(game_state, dict):
                    if 'word' in game_state and 'player1_life' in game_state and 'player2_life' in game_state:
                        active_string = game_state['word']
                        life = game_state['player1_life']
                        life2 = game_state['player2_life']
                    else:
                        print("Received dictionary does not contain expected keys")
                else:
                    print("Received data is not a dictionary")
            except pickle.UnpicklingError as e:
                print(f"Error unpickling data: {e}")

        except ConnectionResetError as e:
            print(f"Connection was reset by the server: {e}")
            break
        except Exception as e:
            print(f"An unexpected error occurred: {e}")
            break

def send_data():
    game_state = {
        'word': active_string,
        'player1_life': life,
        'player2_life': life2
    }
    try:
        client.send(pickle.dumps(game_state))
    except Exception as e:
        print(f"Error sending data: {e}")

def update_words():
    global active_string
    active_string = random.choice(words_list)
    send_data()

def check_input():
    global input_text_p1, input_text_p2, active_string, life, life2, p1_fire, p2_fire

    active_string_lower = active_string.lower()
    input_text_p1_lower = input_text_p1.lower()
    input_text_p2_lower = input_text_p2.lower()

    if input_text_p1_lower == active_string_lower:
        life2 -= 10  # Decrease player 2's life
        life2 = max(life2, 0)
        input_text_p1 = ""
        update_words()
        p1_fire = True  # Trigger player 1 firing animation
    elif input_text_p2_lower == active_string_lower:
        life -= 10  # Decrease player 1's life
        life = max(life, 0)
        input_text_p2 = ""
        update_words()
        p2_fire = True  # Trigger player 2 firing animation
    else:
        p1_fire = False
        p2_fire = False

    send_data()

# List of words to be displayed
words_list = ["Acknowledge", "Achievement", "Administration", "Agreement", "Alternative", "Anniversary",
              "Appointment", "Approximately", "Assessment", "Atmosphere", "Background", "Basketball", "Beginning",
              "Biological", "Boundary", "Breakfast", "Business", "Brilliant", "Beneath", "Behavior", "Campaign",
              "Candidate", "Capability", "Capacity", "Celebration", "Celebrate", "Ceremony", "Certainly",
              "Championship", "Champion", "Changing", "Characteristic", "Characterize", "Chemical", "Childhood",
              "Chicken", "Chocolate", "Cholesterol", "Circumstance", "Cigarette", "Communicate", "Communication",
              "Community", "Comprehensive", "Concentration", "Concerned", "Congressional", "Consciousness",
              "Constitutional", "Decrease", "Defendant", "Defensive", "Democracy", "Democratic", "Demonstrate",
              "Demonstration", "Department", "Dependent", "Depending", "Depression", "Description", "Desperate",
              "Destruction", "Developing", "Development", "Difference", "Discrimination", "Economist", "Economics",
              "Education", "Educational", "Effectively", "Electricity", "Elsewhere", "Emergency", "Emotional",
              "Employment", "Enforcement", "Engineering", "Entertainment", "Environmental", "Establishment",
              "Examination", "Expectation", "Extraordinary", "Financial", "Following", "Football", "Formation",
              "Foundation", "Framework"]


WIDTH = 1400
HEIGHT = 800
screen = pygame.display.set_mode([WIDTH, HEIGHT])
pygame.display.set_caption('Wordsprint Showdown!')
timer = pygame.time.Clock()
fps = 30

# Load images
Background = pygame.image.load('bg.png')
textbox = pygame.image.load('Main_textbox.png')
char1 = pygame.image.load('tank1.png')
char2 = pygame.image.load('char2.png')
p1text = pygame.image.load('textbox1.png')
p2text = pygame.image.load('textbox2.png')
p1Fire = pygame.image.load('Tank_Fire1.png')
p2Fire = pygame.image.load('Tank_Fire.png')
p1Shell = pygame.image.load('Tank_Shells.png')
p2Shell = pygame.image.load('Tank_Shells2.png')

def animate_firing(player):
    """Animate the firing sequence for the specified player."""
    if player == 1:
        fire_size1 = pygame.transform.scale(p1Fire, (80, 80))
        screen.blit(fire_size1, (175, HEIGHT - 143))
        bullet1 = pygame.transform.scale(p1Shell, (80, 80))
        for alpha in range(255, 0, -15):
            bullet1.set_alpha(alpha)
            screen.blit(bullet1, (650, HEIGHT -135))
            pygame.draw.line(screen, 'grey', (220, HEIGHT -100),(680, HEIGHT - 100), 5)
            pygame.display.flip()
            pygame.time.delay(10)
        bullet1.set_alpha(255)
    elif player == 2:
        fire_size2 = pygame.transform.scale(p2Fire, (80, 80))
        screen.blit(fire_size2, (1135, HEIGHT - 143))
        bullet2 = pygame.transform.scale(p2Shell, (80, 80))
        for alpha in range(255, 0, -15):
            bullet2.set_alpha(alpha)
            screen.blit(bullet2, (700, HEIGHT -135))
            pygame.draw.line(screen, 'grey', (750, HEIGHT - 100), (1180, HEIGHT - 100), 5)
            pygame.display.flip()
            pygame.time.delay(10)
        bullet2.set_alpha(255)
    pygame.display.flip()

def player_1():
    tsize1 = pygame.transform.scale(char1, (160, 100))
    screen.blit(tsize1, (50, HEIGHT - 140))

def p1_textbox():
    text1size1 = pygame.transform.scale(p1text, (300, 70))
    screen.blit(text1size1, (50, 550))

def player_2():
    tsize2 = pygame.transform.scale(char2, (160, 100))
    screen.blit(tsize2, (1180, HEIGHT - 140))

def p2_textbox():
    text2size1 = pygame.transform.scale(p2text, (300, 70))
    screen.blit(text2size1, (1040, 550))

def Background_sky():
    size = pygame.transform.scale(Background, (WIDTH, HEIGHT))
    screen.blit(size, (0, 0))

def word_box(word, x, y, padding):
    text_surface = font.render(word, True, 'grey')
    text_width, text_height = text_surface.get_size()
    box_width = text_width + 2 * padding
    box_height = text_height + 2 * padding
    bgsize = pygame.transform.scale(textbox, (box_width, box_height))
    screen.blit(bgsize, (x, y))
    text_rect = text_surface.get_rect(center=(x + box_width // 2, y + box_height // 2))
    screen.blit(text_surface, text_rect,)

def draw_screen():
    screen.blit(base_font.render(f'P1 Life: {life}', True, 'Black'), (50, 620))
    screen.blit(base_font.render(f'P2 Life: {life2}', True, 'Black'), (WIDTH - 250, 620))

def countdown():
    for i in range(3, 0, -1):
        screen.fill('black')
        countdown_text = font.render(f"Game starts in {i}", True, 'white')
        screen.blit(countdown_text, (WIDTH // 2 - countdown_text.get_width() // 2, HEIGHT // 2 - countdown_text.get_height() // 2))
        pygame.display.flip()
        pygame.time.delay(1000)

# Player name input
def enter_player_name():
    player_name = ""
    input_active = False
    input_rect = pygame.Rect(WIDTH // 2 - 150, HEIGHT // 2 - 50, 300, 70)
    while True:
        screen.fill((0, 0, 0))
        pygame.draw.rect(screen, (255, 255, 255), input_rect, 2)
        name_text = font.render("Enter Your Name:", True, 'white')
        screen.blit(name_text, (WIDTH // 2 - name_text.get_width() // 2, HEIGHT // 2 - 150))
        name_surface = font.render(player_name, True, 'white')
        screen.blit(name_surface, (input_rect.x + 10, input_rect.y + 10))

        pygame.display.flip()

        for event in pygame.event.get():
            if event.type == pygame.QUIT:
                pygame.quit()
                exit()
            elif event.type == pygame.KEYDOWN:
                if event.key == pygame.K_BACKSPACE:
                    player_name = player_name[:-1]
                elif event.key == pygame.K_RETURN:
                    return player_name  # Name entered, return it
                else:
                    player_name += event.unicode
            elif event.type == pygame.MOUSEBUTTONDOWN:
                if input_rect.collidepoint(event.pos):
                    input_active = True

# Fetch list of available opponents from the server
def get_available_opponents():
    try:
        client.send(pickle.dumps({'request': 'get_opponents'}))  # Request available opponents
        data = client.recv(4096)
        opponents_list = pickle.loads(data)
        return opponents_list  # A list of opponent names
    except Exception as e:
        print(f"Error retrieving opponent list: {e}")
        return []

# Player chooses an opponent from the list
def choose_opponent(opponents):
    selected_opponent = None
    while selected_opponent is None:
        screen.fill((0, 0, 0))
        title_text = font.render("Choose an Opponent to Invite:", True, 'white')
        screen.blit(title_text, (WIDTH // 2 - title_text.get_width() // 2, 100))

        for index, opponent in enumerate(opponents):
            opponent_text = font.render(opponent, True, 'white')
            screen.blit(opponent_text, (WIDTH // 2 - opponent_text.get_width() // 2, 200 + index * 50))

        pygame.display.flip()

        for event in pygame.event.get():
            if event.type == pygame.QUIT:
                pygame.quit()
                exit()
            elif event.type == pygame.MOUSEBUTTONDOWN:
                mouse_pos = event.pos
                for index, opponent in enumerate(opponents):
                    text_rect = pygame.Rect(WIDTH // 2 - 100, 200 + index * 50, 200, 50)
                    if text_rect.collidepoint(mouse_pos):
                        selected_opponent = opponent
                        break

    return selected_opponent

# Send an invite to the selected opponent
def send_invite(player_name, opponent_name):
    invite_data = {'request': 'invite', 'player_name': player_name, 'opponent_name': opponent_name}
    try:
        client.send(pickle.dumps(invite_data))
    except Exception as e:
        print(f"Error sending invite: {e}")

def search_for_opponent():
    # This function simulates the process of waiting for an opponent to accept the invite.
    # For the purpose of this demo, let's just return True after a delay to simulate acceptance.
    pygame.time.delay(5000)  # Simulate a delay while waiting for the opponent's response
    return True  # Opponent accepts the invite

def game_loop():
    player_name = enter_player_name()  # Get player's name

    opponents = get_available_opponents()  # Get list of available opponents
    if opponents:
        selected_opponent = choose_opponent(opponents)  # Player selects an opponent
        send_invite(player_name, selected_opponent)  # Send invite
        if search_for_opponent():  # Search and wait for opponent response
            print(f"Opponent {selected_opponent} accepted the invite.")
            countdown()
            main_game_loop()
        else:
            print(f"Opponent {selected_opponent} declined the invite.")
    else:
        print("No available opponents found.")
        pygame.quit()
        exit()

def main_game_loop():
    global input_text_p1, input_text_p2, active_string, countdown_started, p1_fire, p2_fire

    # Start background music
    pygame.mixer.music.play(-1)  # Play the background music in a loop

    # Start receiving data from the server
    threading.Thread(target=receive_data, daemon=True).start()

    word_box_padding = 20  # Padding for the word box

    while True:
        screen.fill('black')
        Background_sky()

        for event in pygame.event.get():
            if event.type == pygame.QUIT:
                pygame.quit()
                exit()
            elif event.type == pygame.KEYDOWN:
                if input_active_p1:
                    if event.key == pygame.K_BACKSPACE:
                        input_text_p1 = input_text_p1[:-1]
                    elif event.key == pygame.K_RETURN:
                        check_input()
                    else:
                        input_text_p1 += event.unicode

                if input_active_p2:
                    if event.key == pygame.K_BACKSPACE:
                        input_text_p2 = input_text_p2[:-1]
                    elif event.key == pygame.K_RETURN:
                        check_input()
                    else:
                        input_text_p2 += event.unicode
            elif event.type == pygame.MOUSEBUTTONDOWN:
                if input_rect_p1.collidepoint(event.pos):
                    input_active_p1 = True
                    input_active_p2 = False
                elif input_rect_p2.collidepoint(event.pos):
                    input_active_p1 = False
                    input_active_p2 = True

        # Display players and their text boxes
        player_1()
        p1_textbox()
        player_2()
        p2_textbox()

        # Display word box
        word_box(active_string, WIDTH // 2 - 150, HEIGHT // 2 - 100, word_box_padding)

        # Display text input from both players
        text_surface_p1 = font.render(input_text_p1, True, 'white')
        text_surface_p2 = font.render(input_text_p2, True, 'white')
        screen.blit(text_surface_p1, (input_rect_p1.x + 10, input_rect_p1.y + 10))
        screen.blit(text_surface_p2, (input_rect_p2.x + 10, input_rect_p2.y + 10))


        draw_screen()
        if p1_fire:
            animate_firing(1)
        if p2_fire:
            animate_firing(2)

        pygame.display.flip()
        timer.tick(fps)


if __name__ == "__main__":
    game_loop()

