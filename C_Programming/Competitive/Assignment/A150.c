// Decimal        65
// Octal         0101
// HexaDecimal   0X41

#include<stdio.h>

void Display(char ch)
{
    printf("Decimal      : %d\n", ch);
    printf("Octal        : %o\n", ch);
    printf("Hexadecimal  : 0X%X\n", ch);
}

int main()
{
    char cValue = '\0';

    printf("Enter the character : ");
    scanf("%c",&cValue);

    Display(cValue);

    return 0;
}