def square(number):
    """Determines the number of grains of wheat on a particular square of the chessboard

    :param number: indicates the index of the square
    :return: the number of grains of wheat on that square
    """
    if number < 1 or number > 64:
        raise ValueError("square must be between 1 and 64")
    return 2**(number - 1)

def total():
    """Iterates through all the squares on the chessboard to determine the total nuymber of grains of wheat

    :return: the total number of grains of wheat on the chessboard
    """
    total = 0
    for index in range(64):
        total += square(index + 1)
    return total
