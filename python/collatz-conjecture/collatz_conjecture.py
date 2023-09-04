def steps(number):
    steps = 0
    if number <= 0:
        raise ValueError("Only positive integers are allowed")
    while number > 1:
        steps = steps + 1
        number = process_number(number)
    return steps


def process_number(number):
    if number % 2 == 0:
        return number / 2
    else:
        return number * 3 + 1
