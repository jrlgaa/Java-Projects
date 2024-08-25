import random
import time
import os
import shutil


def draw_box_with_words_and_tanks(width, height, *words):
    # Ensure we have enough space for the words and their separators
    if len(words) > 3:
        raise ValueError("This function currently supports up to 3 words.")

    # Create a list to hold the box lines
    box_lines = []

    # Top border
    box_lines.append('+' + '-' * (width - 2) + '+')

    # Prepare the words for the box
    word_line = ''.join(f"{word:<{width // 3 - 2}}" for word in words)

    # Center the line of words
    padding = (width - len(word_line) - 2) // 2
    box_lines.append('|' + ' ' * padding + word_line + ' ' * (width - len(word_line) - padding - 2) + '|')

    # Fill the rest of the box except for the last rows for the tanks
    for _ in range(height - 8):  # Adjusted to leave space for tanks
        box_lines.append('|' + ' ' * (width - 2) + '|')

    # Add the tanks
    tank_lines = draw_battle_tanks(width)
    for line in tank_lines:
        box_lines.append('|' + line + '|')

    # Bottom border
    box_lines.append('+' + '-' * (width - 2) + '+')

    return box_lines


def generate_random_word(words_list):
    return random.choice(words_list)


def draw_battle_tanks(width):
    # ASCII art for Player 1 and Player 2 tanks side by side
    tank_art_p1 = [
        "  //\\_//P1\\_/\\____  ",
        " ||              ____",
        "  \\___________//    "
    ]

    tank_art_p2 = [
        "  //\\_//P2\_/\____  ",
        "||           ____",
        "  \\___________/    "
    ]

    # Create a list to hold the tank lines
    tank_lines = []

    # Construct tank drawing
    for p1_line, p2_line in zip(tank_art_p1, tank_art_p2):
        combined_line = p1_line + ' ' * 4 + p2_line  # Add space between tanks
        padded_line = combined_line.center(width - 2)  # -2 for box borders
        tank_lines.append(padded_line)

    return tank_lines


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

# Width and height of the box
width = 100
height = 25


def clear_screen():
    os.system('cls' if os.name == 'nt' else 'clear')


while True:
    # Generate random words
    random_word1 = generate_random_word(words_list)
    random_word2 = generate_random_word(words_list)
    random_word3 = generate_random_word(words_list)

    # Clear the screen
    clear_screen()

    # Get terminal size
    terminal_size = shutil.get_terminal_size()
    terminal_width = terminal_size.columns
    terminal_height = terminal_size.lines

    # Draw the box with the three random words and tanks
    box_lines = draw_box_with_words_and_tanks(width, height, random_word1, random_word2, random_word3)

    # Calculate top padding for centering
    top_padding = (terminal_height - height) // 2

    # Print top padding
    print('\n' * top_padding)

    # Print each line of the box centered
    for line in box_lines:
        left_padding = (terminal_width - width) // 2
        print(' ' * left_padding + line)

    # Wait for 3 seconds
    time.sleep(3)

