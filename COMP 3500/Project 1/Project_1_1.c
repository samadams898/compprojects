/*
 * COMP 3500: Project 1_1 - Process Management
 * Samuel Adams and Tom Morin
 * Auburn University
 *
 * This source code shows how to pass commandline arguments to your progrm
 *
 * How to compile?
 * $gcc Project_1_1.c -o project_1_1
 *
 * How to run?
 * $./project_1_1 inputfile outputfile
 * 
 * Note: Ensure appropriate error checking at each step.
 * 
 */

#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <stdio.h>
#include <unistd.h>
#include <sys/types.h>
#include <sys/types.h>
#include <string.h>
#include <signal.h>



FILE *in_file;
FILE *out_file;
char *str;
#define BUFFER_SIZE 25
#define READ_END 0
#define WRITE_END 1
int totalChar = 0;

//int numofchars= 0;

int main( int argc, char *argv[] )  {

    if (argc == 1 || argc > 4) {
        printf("Usage: ./project_1_1 inputfile outputfile\n");
        return 0;
    }
/** STEP: OPEN INPUTFILE WITH READ OPTION **/
in_file  = fopen(argv[1], "r"); // read only 
/** STEP: OPEN OUTPUTFILE WITH CREATE/WRITE OPTION **/ 

out_file = fopen(argv[2], "w"); // write only
    if (in_file == NULL || out_file == NULL) 
            {   
              printf("Error, file does not exist\n"); 
              return 1;	
			}
   

pid_t child;
int fd[2]; // str 

    if (pipe(fd) == -1) {
		fprintf(stderr,"Pipe failed");
		return 1;
	}
	//pipe(fd);

    child = fork();
	
    if (child < 0){
        fprintf(stderr, "Fork failed");
        return 1;
    }
    if (child > 0) {  /* parent process */
		/* Close unused end of pipe */
		close(fd[READ_END]);
		//fflush(in_file);
		/* Loop through file till eof condition */
		while (!feof(in_file))  {
			int readCount;
			
    		fgets(&str, sizeof str, in_file);
			/** write current string to write end of pipe */
			write(fd[WRITE_END], &str, strlen(str) + 1); 

			//close(fd[WRITE_END]);
				
			
			read(fd[READ_END], &readCount, BUFFER_SIZE);

			//close(fd[READ_END]);

			totalChar += readCount;
			readCount = 0;

			
			
		}
			
		close(fd[WRITE_END]);
		//close(fd[READ_END]);
		//char *writestr = "num of chars" + totalChar;
		//fputs(writestr, out_file);
		
	}
	else { /* child process */
		char *tempstr;
		/* close the unused end of the pipe */
		close(fd[WRITE_END]);
        
		/* read from the pipe */
		read(fd[READ_END], &tempstr, strlen(tempstr) + 1);
		
		
		//close(fd[READ_END]);
		
		
		//fprintf("Child read %s\n", str);
		int charIndex = 0;
    	int numofchars = 0;
		int currentLineCount;
		while(tempstr[charIndex] != 0){
				if((tempstr[charIndex] >= 'a' && tempstr[charIndex] <= 'z' ) || (tempstr[charIndex] >= 'A' && tempstr[charIndex] <= 'Z')) {
					numofchars++;
				}
		charIndex++;
		}
		currentLineCount = numofchars;
		
	//fflush(in_file);
	
	write(fd[WRITE_END], &currentLineCount, BUFFER_SIZE);

	//close(fd[WRITE_END]);
	close(fd[READ_END]);
	exit(0);
	}



fprintf("num of chars%d\n", totalChar);
printf("done\n");
return 0;
}
