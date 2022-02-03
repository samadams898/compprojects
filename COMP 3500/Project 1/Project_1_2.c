/*
 * COMP 3500: Project 1_2 - Process Management
 * Samuel Adams and Tom Morin
 * Auburn University
 *
 * This source code shows how to pass commandline arguments to your progrm
 *
 * How to compile?
 * $gcc project_1_2.c -o project_1_2
 *
 * How to run?
 * $./project_1_2 inputfile outputfile
 * 
 * Note: Ensure appropriate error checking at each step.
 * 
 */

#include <stdio.h>
#include <string.h>
#include <pthread.h>
#include <stdlib.h>

//char inputstr[512 + 1];
char *inputstr;
FILE *in_file;
FILE *out_file;
int numofchars;
//int *n;

int totalChar = 0;
int currentLineCount = 0;

int main( int argc, char *argv[] )  {

    if (argc == 1 || argc > 4) {
        printf("Usage: ./project_1_2 inputfile outputfile\n");
        return 0;
    }

/** STEP: OPEN INPUTFILE WITH READ OPTION **/


/** STEP: OPEN INPUTFILE WITH READ OPTION **/
in_file  = fopen(argv[1], "r"); // read only 
/** STEP: OPEN OUTPUTFILE WITH CREATE/WRITE OPTION **/ 


void *runner(void *param);
pthread_t tid; /* the thread identifier */
pthread_attr_t attr; /* set of attributes for the thread */
/* get the default attributes */

  while(!feof(in_file)){

    fgets(&inputstr, sizeof inputstr, in_file);

    pthread_attr_init(&attr);
/* create the thread */
/* now wait for the thread to exit */
    pthread_create(&tid, &attr, runner, &inputstr);

    pthread_join(tid,NULL);
    totalChar += currentLineCount;

 } 
/** STEP: CREATE/INVOKE A PTHREAD TO PROCESS THE INPUT LINE **/
/** STEP: CHILD THREAD SCANS THE INPUT LINE & COUNTS THE ALPHABETIC CHARACTERS; PROVIDES THE COUNT TO PARENT THREAD & EXITS **/
/** NOTE: Based on our discussions in class, devise approach to exchange input (line of text) and the output (character count) between parent and child threads **/

/** STEP: PARENT THREAD CONITNUES WITH READING LINES FROM INPUTFILE & CREATING CHILD THREADS **/

/** STEP: PARENT THREAD RECEIVES AND KEEPS TRACK OF THE COUNTS FROM ALL CHILD PROCESSES; COMPUTES TOTAL; PRINTS IT TO OUTPUTFILE IN REQUIRED FORMAT AND EXITS **/
    
    printf("num of chars%d\n", totalChar);
    return 0;
}
void *runner(void *param) 
{
    int charIndex = 0;
    int numofchars = 0;
    char *currentline = param;
	while(currentline[charIndex] != 0){
				if((currentline[charIndex] >= 'a' && currentline[charIndex] <= 'z' ) || (currentline[charIndex] >= 'A' && currentline[charIndex] <= 'Z')) {
					numofchars++;
				}
		charIndex++;
		}
        currentLineCount = numofchars;

	pthread_exit(0);

}
