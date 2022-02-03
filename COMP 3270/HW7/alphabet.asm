

INCLUDE Irvine32.inc
.386
.model flat,stdcall
.stack 4096
ExitProcess proto,dwExitCode:dword


.data
afound BYTE "alphabet found", 0
a_notfound BYTE "alphabet not found", 0

MyArray BYTE 67h, -3, 74h, 'G', 'W', 92h
;;MyArray BYTE 'A', 'B', 'C', 'D'
;;MyArray BYTE 60h, 20h, 30h
;;MyArray BYTE 10h, 'D'
alphabet BYTE ? ,0
.code   


main PROC 

   mov ecx, lengthof MyArray
 ;; mov esi, offset MyArray
   mov esi, -1
   mov eax, 0
   
  
   scan_array:
    cmp esi, lengthof myArray
    jge non_alphabetic
   
    inc esi
    mov al, MyArray[esi]
    
   cmp al, 'A'
   jl scan_array
   cmp  al, 'Z'
   jle alphabet_found
  

    
    loop scan_array


  non_alphabetic:
    mov edx, offset a_notfound
    call WriteString
    exit
    
  alphabet_found:
    
    mov alphabet, al
    
    
    mov edx, offset afound
    call WriteString
    call crlf
    ;;pop eax
    mov bl, al
    call WriteChar
    pop ecx
    call crlf
    mov eax, esi
    call WriteInt
    

    exit 
        
exit
main ENDP

END main