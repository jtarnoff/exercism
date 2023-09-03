def is_armstrong_number(number):
    '''Checks if the sum of each of the digits multiplied by the number of digits is equal to the number itself

    :param number: the base number used for the calculation
    :return: a boolean value indicated whether the number is an Armstrong number
    '''
    str_number = str(number)
    num_digits = len(str_number)
    total = 0
    for digit_str in str_number:
        total += (int(digit_str) ** num_digits)
    return number == total
