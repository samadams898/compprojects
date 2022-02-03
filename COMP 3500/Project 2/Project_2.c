/*
 * COMP 3500: Project 2 - Synchronization
 * Shehenaz Shaik
 * Auburn University
 * Samuel Adams and Tom Morin
 * Project #2: Starter code
 * 
 * This source code shows how to 
 * pass commandline arguments to your program, 
 * create threads, and 
 * includes psuedocode for readers-writers problem
 *
 * How to compile?
 * $gcc Project_2.c -o Project_2
 *
 * How to run?
 * $./project_2 readercount writercount outputfile
 * 
 * Note: Ensure appropriate error checking at each step.
 * Note: This is a psuedocode. Enter valid code segments and format prior to compilation/execution.
 * Note: No assumptions must be made regarding number of reader/writer threads.
 * Note: Look for the comments of the form /** STEP: ...; Ensure to add code segments, as appropriate. 
 * 
 */

#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>
#include <malloc.h>
#include <time.h>
#include <unistd.h>
#include <string.h>
#include <pthread.h>
#include <semaphore.h>



int val; /* this data is shared by the thread(s) */
int m=0; /* number of readers */
int n=0; /* number of writers */
FILE *fd;


bool ready = false;

sem_t sem, rmutex, wmutex; /* Semaphore to access the shared integer 'val' */

void* reader(); /* the reader thread */
void* writer(); /* the writer thread */


int main( int argc, char *argv[] )  {

/** STEP: FOLLOWING TWO LINES SHOW A SAMPLE TO DECLARE A THREAD-ID AND THREAD-ATTRIBUTES FOR ONE THREAD; MODIFY THESE TO DECLARE FOR M READERS AND N WRITERS  **/
	pthread_t Rtid[m]; /* the thread identifier */
	pthread_t Wtid[n];
	pthread_attr_t Rattr;
	pthread_attr_t Wattr; /* set of attributes for the thread */


    if (argc != 4) {
        printf("Usage: ./project_2 readercount writercount outputfile\n");
        return 0;
    }

/** STEP: VALIDATE THE COMMAND LINE PARAMETERS FOR CORRECT COUNT, VALID TYPE, AND SEQUENCE; INCLUDE THE CODE SEGMENT HERE. **/


m = atoi(argv[1]);
n = atoi(argv[2]);

/** STEP: OPEN OUTPUTFILE WITH CREATE/WRITE OPTION; fd IS FILE DESCRIPTOR **/ 
   

fd = fopen(argv[3], "w");

/** STEP: INITIALIZE SEMAPHORE(S) AND SHARED VARIABLE(S), IF ANY, AS APPROPRIATE; REPLACE SEMINITVAL WITH A VALID INTEGER VALUE **/
    sem_init(&sem, 0, val);
	sem_init(&rmutex, 0, 1);
	sem_init(&wmutex, 0, 1);


/** STEP: FOLLOWING LINE SHOWS A SAMPLE TO INITIALIZE THREAD-ATTRIBUTES FOR ONE THREAD; MODIFY THIS TO INITIALIZE ATTRIBUTES FOR M READERS AND N WRITERS  **/
	/* get the default attributes */
	// idk if this works
	for(int i = 0; i <= m; i++){
		pthread_attr_init(&Rattr);
	}
	for(int i = 0; i <= n; i++){
		pthread_attr_init(&Wattr);
	}


/** STEP: FOLLOWING LINE SHOWS A SAMPLE TO CREATE A READER THREAD; MODIFY THIS TO CREATE M READERS WITH VALID THREAD IDS AND ATTRIBUTES**/
	/* create the thread */
	for(int i = 0; i <= m; i++) {
		pthread_create(&Rtid[i], &Rattr, reader, fd);
	}


/** STEP: FOLLOWING LINE SHOWS A SAMPLE TO CREATE A WRITER THREAD; MODIFY THIS TO CREATE N WRITERS WITH VALID THREAD IDS AND ATTRIBUTES **/
	/* create the thread */
		for(int i = 0; i <= n; i++){
		pthread_create(&Wtid[i], &Wattr, writer, fd);
		}

/** STEP: ALLOW THREADS TO ACCESS THE SHARED VARIABLE **/
	ready = true;


/** STEP: FOLLOWING LINE SHOWS A SAMPLE TO WAIT FOR A THREAD; MODIFY THIS TO WAIT FOR M READERS AND N WRITERS **/
	/* now wait for the thread to exit */
	for(int i= 0; i <= m; i++){
		pthread_join(Rtid[i],NULL);
	}
	for(int i = 0; i <= n; i++){

	pthread_join(Wtid[i],NULL);	
	}

/** STEP: DESTROY SEMAPHORE(S) **/
    sem_destroy(&sem);
	sem_destroy(&rmutex);
	sem_destroy(&wmutex);
	

}




/**
 * The WRITER thread will begin control in this function
 * Parameter passed: file descriptor for output file
 * format to request a semaphore sem: sem_wait(&sem);
 * format to release a semaphore sem: sem_post(&sem); 
 */
void *writer(void *param) 
{
	int oldval;

	/** WAIT UNTIL ALL READER/WRITER THREADS ARE CREATED **/
	while (!ready) sleep(1);

	/** ACCESS THE SHARED INTEGER VARIABLE 10 TIMES; REPEAT THE FOLLOWING BLOCK OF ENTRY-CS-EXIT SECTIONS 10 TIMES **/
		/** STEP: ENTRY SECTION: ADD CODE HERE**/
		sem_wait(&wmutex);
	//	sem_wait(&sem);
		for(int i = 0; i <= 10; i++){	
		
		fprintf(fd,"WRITER WAITING TO ENTER CS\n");


		/** CRITICAL SECTION **/
		oldval = val; val = val + 1;
		fprintf(fd,"WRITER: UPDATED VAL FROM %d to %d\n", oldval, val);


		/** STEP: EXIT SECTION: ADD CODE HERE **/
		fprintf(fd,"WRITER EXITED CS\n");
		
		
		}
	//	sem_post(&sem);
		sem_post(&wmutex);	

	pthread_exit(0);
}




/**
 * The READER thread will begin control in this function
 * Parameter passed: file descriptor for output file
 * format to request a semaphore sem: sem_wait(&sem);
 * format to release a semaphore sem: sem_post(&sem); 
 * 
 * IMPLEMENT SOLUTION TO SECOND READERS-WRITERS PROBLEM: 
		(WRITERS ARE GIVEN PRIORITY; IF A WRITER IS WAITING IN ENTRY SECTION, NO NEW READER SHOULD ENTER CS)
 */
void *reader(void *param) 
{
	/** WAIT UNTIL ALL READER/WRITER THREADS ARE CREATED **/
	while (!ready) sleep(1);

	/** ACCESS THE SHARED INTEGER VARIABLE 10 TIMES; REPEAT THE FOLLOWING BLOCK OF ENTRY-CS-EXIT SECTIONS 10 TIMES **/
		/** STEP: ENTRY SECTION: ADD CODE HERE **/
		sem_wait(&rmutex);
	//	sem_wait(&sem);
		for(int i = 0; i <= 10; i++){
		
		/* print one of these depending on whether the reader is waiting to acquire the semaphore */
		fprintf(fd,"READER WAITING TO ENTER CS\n"); /*OR*/ fprintf(fd,"READER ENTERING CS WITHOUT WAITING\n"); 


		/** CRITICAL SECTION **/
		fprintf(fd,"READER: CURRENT VAL: %d\n", val);


		/** STEP: EXIT SECTION: ADD CODE HERE **/
		fprintf(fd,"READER EXITED CS\n");
		
		}
	//	sem_post(&sem);
		sem_post(&rmutex);
	pthread_exit(0);
		
}

