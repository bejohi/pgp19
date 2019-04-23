#include <stdio.h>
#include <stdbool.h>
#include <string.h>

// idea from: https://www.programmingsimplified.com/c/source-code/c-anagram-program
bool is_anagram(char* a, char* b){

    int char_counter_word_a[26] = {0};
    int char_counter_word_b[26] = {0};
 
    int i = 0;
    while (a[i] != '\0'){
        char_counter_word_a[a[i]-'a']++;
        i++;
    }
    i = 0;
 
    while (b[i] != '\0'){
        char_counter_word_b[b[i]-'a']++;
        i++;
    }
 
    for (i = 0; i < 26; i++){
        if (char_counter_word_a[i] != char_counter_word_b[i]){
            return false;
        }
        
    }
 
    return true;

}

int main(){
    char* a = "abc";
    char* b = "bca";
    bool is_anagram_result = is_anagram(a,b);
    printf("%d\n",is_anagram_result);
    return 0;
}