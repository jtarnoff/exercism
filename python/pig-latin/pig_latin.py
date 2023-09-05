def translate(text: str):
    string = ""
    return (string.join(translate_word(word)) for word in text.split(' '))


def translate_word(text):
    if passes_rule_three(text):
        return apply_rule_three(text)
    if passes_rule_one(text):
        return apply_rule_one(text)
    if passes_rule_two(text):
        return apply_rule_two(text)


def is_vowel(char):
    return char in ('a', 'e', 'i', 'o', 'u')


def is_vowel_or_y(char):
    return char in ('a', 'e', 'i', 'o', 'u', 'y')


def passes_rule_one(text):
    return is_vowel(text[0]) or text[:2] in ('xr', 'yt')


def apply_rule_one(text):
    return text + 'ay'


def passes_rule_two(text):
    return not is_vowel(text[0])


def apply_rule_two(text):
    first_vowel_index = next(i for i, v in enumerate(text) if is_vowel_or_y(v))
    return str[first_vowel_index:] + str[0:first_vowel_index] + 'ay'


def passes_rule_three(text):
    return text[0:2] == 'qu' or (not is_vowel(text[0]) and text[1:3] == 'qu')


def apply_rule_three(text):
    if text[0] == 'q':
        return text[2:] + text[:2] + 'ay'
    return text[3:] + text[:3] + 'ay'
