#include <stdio.h>
#include <stdlib.h>
#include <string.h>

char* concat(char* string1, char* string2){
    int new_str_len = strlen(string1) * sizeof(char) + strlen(string2) * sizeof(char) +1;
    char* new_str = malloc(new_str_len);

    int counter = 0;
    for(int i = 0; i < strlen(string1);i++){
        new_str[counter] = string1[i];
        counter++;
    }
    for(int i = 0; i < strlen(string1);i++){
        new_str[counter] = string2[i];
        counter++;
    }
    new_str[counter] = '\0';
    return new_str;
}

int main() {
    char* str1 = "ab";
    char* str2 = "cd";
    char* str3 = concat(str1,str2);
    printf("%s\n",str3);
    printf("%dl\n",strlen(str3));


    return EXIT_SUCCESS;
}