// Guessing Game 

#include <stdio.h>
int main() {
    int number_to_guess = 66;
    int attempts = 0;
    int guess;

    printf("Welcome To The Alvee's Guessing Game !!!\n");

    while (1) {
        printf("Enter Your Guess : ");
        scanf("%d", &guess);
        attempts++;

        if (guess == number_to_guess) {
            printf("Congratulations! You Guessed The Number %d in %d attempts\n", number_to_guess, attempts);
            break;
        } 
        else if (guess > number_to_guess) {
            printf("Too High! Try Again\n");
        } 
        else if (guess < number_to_guess) {
            printf("Too Low! Try Again\n");
        }
    }
    return 0;
}
