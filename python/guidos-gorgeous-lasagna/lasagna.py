"""Functions used in preparing Guido's gorgeous lasagna.

Learn about Guido, the creator of the Python language:
https://en.wikipedia.org/wiki/Guido_van_Rossum

This is a module docstring, used to describe the functionality
of a module and its functions and/or classes.
"""

EXPECTED_BAKE_TIME = 40
PREPARATION_TIME = 2


def bake_time_remaining(elapsed_bake_time):
    """Calculate the bake time remaining.

    :param elapsed_bake_time: int - baking time already elapsed.
    :return: int - remaining bake time (in minutes) derived from 'EXPECTED_BAKE_TIME'.

    Function that takes the actual minutes the lasagna has been in the oven as
    an argument and returns how many minutes the lasagna still needs to bake
    based on the `EXPECTED_BAKE_TIME`.
    """

    return EXPECTED_BAKE_TIME - elapsed_bake_time


def preparation_time_in_minutes(number_of_layers):
    """Calculate the preparation time.

    :param number_of_layers: int - number of layers of lasagna, used to calculate prep time.
    :return: int - preparation time (in minutes)

    Function that takes the number of layers and calculates the amount of preparation time needed
    """
    return number_of_layers * PREPARATION_TIME


def elapsed_time_in_minutes(number_of_layers, elapsed_bake_time):
    """Calculate the elapsed time, both preparation and cooking.

    :param number_of_layers: int - number of layers of lasagna, used to calculate prep time.
    :param elapsed_bake_time: int - number of minutes dish has been cooking.
    :return: int - total elapsed bake time (in minutes)

    Function that takes the number of layers and elapsed time cooking in minutes and calculates the total elapsed time, 
    both preparation and cooking
    """
    return preparation_time_in_minutes(number_of_layers) + elapsed_bake_time