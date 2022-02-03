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
char str[512 + 1];
#define BUFFER_SIZE 25
#define READ_END 0
#define WRITE_END 1

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
int fd2[2]; // num chars
int *n;
int numofchars;

    if (pipe(fd) == -1) {
		fprintf(stderr,"Pipe failed");
		return 1;
	}
while (fgets(str, sizeof n, in_file) != 0)  {
   
    child = fork();
  	//pipe(fd);
   	//pipe(fd2);
	int charIndex = 0;

    if (child < 0){
        fprintf(stderr, "Fork failed");
        return 1;
    }
    if (child > 0) {  /* parent process */
		
		
		
		close(fd[READ_END]);
		write(fd[WRITE_END], str, BUFFER_SIZE); 
				
		close(fd[WRITE_END]);

		
		
		
		close(fd2[WRITE_END]);
		read(fd2[READ_END], numofchars, BUFFER_SIZE);
		
		close(fd2[READ_END]);	
		printf("num of chars%d\n", numofchars);
		
		
		
	}
	else { /* child process */
		
		
		/* close the unused end of the pipe */
		close(fd[WRITE_END]);
        
		/* read from the pipe */
		read(fd[READ_END], str, n);
		close(fd[READ_END]);
		
		
		
		printf("Child read %s\n", str);
		

		while(str[charIndex] != 0){
				if((str[charIndex] >= 'a' && str[charIndex] <= 'z' ) || (str[charIndex] >= 'A' && str[charIndex] <= 'Z')) {
					numofchars++;
				}
		charIndex++;
		}
		

	close(fd2[READ_END]);

	write(fd2[WRITE_END], numofchars, BUFFER_SIZE);
		
	close(fd2[WRITE_END]);
    
		
	}
	
	
	
}


printf("done\n");
return 0;
}
