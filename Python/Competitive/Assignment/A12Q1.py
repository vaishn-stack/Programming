def ChkVowel(ch):
    if ch == 'a' or ch == 'e' or ch == 'i' or ch == 'o' or ch == 'u' or \
       ch == 'A' or ch == 'E' or ch == 'I' or ch == 'O' or ch == 'U':
        return True
    else:
        return False

def main():
    value = input("Enter a character: ")

    if ChkVowel(value):
        print("Vowel")
    else:
        print("Consonant")

if __name__ == "__main__":
    main()