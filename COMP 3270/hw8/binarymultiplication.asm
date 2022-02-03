 .386
.model flat,stdcall
.stack 4096
ExitProcess proto, dwExitCode:dword

include Irvine32.inc

.data
	msg byte "Type in an int: ",0
    result byte "* 11: ",0
    
    dhval byte "dh: ",0
    dlval byte ", dl: ",0
    
.code
main proc
	mov edx, offset msg
	call WriteString
	call ReadInt
    call bin_mult
    mov edx, offset result
    call WriteString
    call WriteInt

    call crlf
    call crlf

  mov edx, 0
    call crlf           ;   A    1      B  C   2    3     D    4
    mov eax, 0A1BC23D4h ;  1010 0001 1011 0111 0010 0011 1101 0100
    and al, 00001111b   ;                      0010 0011 0000 0100
    rol al, 4           ;                      0010 0011 0100 0000
    ror ax, 4           ;  1010 0001 1011 0111 0000 0010 0011 0100
    rol ax, 4           ;  1010 0001 1011 0111 0010 0011 0100 0000
                            
                        ;    0     A    1    B    C    2    3   4
    ror eax, 4          ;  0000 1010 0001 1011 0111 0010 0011 0100
    
                        ;  0000 0000 0001 0000 0000 0010 0011 0100
    mov dl, al
                            
    ror eax, 4          ;  0000 0000 0000 0001 0000 0000 0010 0011
                        ;  0000 0000 0000 0001 0010 0011 0010 0000
    rol ax, 8
    ror eax, 4          ;  0000 0000 0000 0000 0001 0010 0010 0000
    mov dh, ah
   
    push edx
    mov edx, offset dhval
    call WriteString
    pop edx
    movzx eax, dh
    call WriteHex
    push edx
    mov edx, offset dlval
    call WriteString
    pop edx
    movzx eax, dl
    call WriteHex
    call crlf

	exit
main endp

bin_mult proc uses ebx ecx edx
    mov ebx, 11d
    mov edx, eax    ; store original multiplicand into EDX
    mov ecx, 32     ; loop for 32 bits
    mov eax, 0      ; eax will accumulate the result
 
begin_loop:
    shr edx, 1      ; shift lowest bit into carry flag
    jnc dont_add    ; jump if carry flag not set
    add eax, ebx
dont_add:
    shl ebx, 1      ; shifting multiplies EBX by 2
    loop begin_loop

    ret
bin_mult endp

end main