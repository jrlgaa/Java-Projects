import pygame
import socket
import threading
import pickle
import random
from pygments.styles.paraiso_dark import RED

# Define the server details
SERVER_IP = '127.0.0.1'  # Use localhost if running on the same machine
PORT = 5555
ADDR = (SERVER_IP, PORT)

# Create a socket object
client = socket.socket(socket.AF_INET, socket.SOCK_STREAM)

try:
    client.connect(ADDR)
except ConnectionRefusedError:
    print(f"Failed to connect to {SERVER_IP}:{PORT}. Is the server running?")
    exit(1)

# Initialize Pygame
pygame.init()

# Game variables
active_string = "P1 Tank"
active_string2 = "P2 Tank"
life = 200
life2 = 200

def receive_data():
    global active_string, active_string2, life, life2
    while True:
        try:
            data = client.recv(4096)
            if data:
                game_state = pickle.loads(data)
                active_string = game_state['word']
                life = game_state['player1_life']
                life2 = game_state['player2_life']
        except ConnectionResetError:
            break

def send_data():
    game_state = {
        'word': active_string,
        'player1_life': life,
        'player2_life': life2
    }
    client.send(pickle.dumps(game_state))

# Start a thread to receive data
thread = threading.Thread(target=receive_data)
thread.start()

# Screen dimensions and setup
WIDTH = 1400
HEIGHT = 800
screen = pygame.display.set_mode([WIDTH, HEIGHT])
pygame.display.set_caption('Wordsprint Showdown!')
timer = pygame.time.Clock()
fps = 120

# Fonts setup
font = pygame.font.Font('Pixel Tandy.otf', 30)
header_font = pygame.font.SysFont('Pixel Tandy.otf', 35)
banner_font = pygame.font.SysFont('Pixel Modex.otf', 30)

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

# Load assets
Background = pygame.image.load('bg.png')
char1 = pygame.image.load('char.png')
char2 = pygame.image.load('char.png')

def Background_sky(bg):
    size = pygame.transform.scale(bg, (WIDTH, HEIGHT))
    screen.blit(size, (0, 0))

def word_box(screen, word, x, y, width, height):
    pygame.draw.rect(screen, RED, (x, y, width, height), 2)
    text_surface = font.render(word, True, RED)
    text_rect = text_surface.get_rect(center=(x + width // 2, y + height // 2))
    screen.blit(text_surface, text_rect)

def draw_screen():
    pygame.draw.rect(screen, 'white', [0, 0, WIDTH, HEIGHT], 5)
    pygame.draw.rect(screen, 'black', [0, 0, WIDTH, HEIGHT], 3)
    screen.blit(header_font.render(f'"{active_string}"', True, 'Black'), (50, HEIGHT - 70))
    screen.blit(header_font.render(f'"{active_string2}"', True, 'Black'), (1250, HEIGHT - 70))
    screen.blit(banner_font.render(f'P1 Life: {life}', True, 'Black'), (10, 650))
    screen.blit(banner_font.render(f'P2 Life: {life2}', True, 'Black'), (1270, 650))

def update_words():
    global active_string
    active_string = random.choice(words_list)
    send_data()

# Timing variables for word updates
change_interval = 4000
last_change_time = pygame.time.get_ticks()

# Main game loop
run = True
while run:
    timer.tick(fps)
    Background_sky(Background)
    draw_screen()

    current_time = pygame.time.get_ticks()
    if current_time - last_change_time >= change_interval:
        update_words()
        last_change_time = current_time

    word_box(screen, active_string, 600, 50, 260, 100)
    pygame.display.flip()

    for event in pygame.event.get():
        if event.type == pygame.QUIT:
            run = False

pygame.quit()
client.close()

