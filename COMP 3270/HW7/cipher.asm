
include irvine32.inc
.386
.model flat,stdcall
.stack 4096
ExitProcess proto, dwExitCode:dword


.data
	txt byte "Samuel Adams",0
	key = 30h
	
.code
main proc
	mov edx, offset txt
	call WriteString
	call crlf

	mov ecx, lengthof txt - 1 
	mov esi, 0					
	encode:
		xor txt[esi], key		;encodes txt using 30h as key
		inc esi

	loop encode

	
	mov edx, offset txt
	call WriteString    ;prints encoded txt
	call crlf

	mov ecx, lengthof txt - 1
	mov esi, 0
	decode:
		xor txt[esi], key   ; decodes txt
		inc esi
	loop decode

	mov edx, offset txt		; prints decoded txt
	call WriteString
	call crlf
		
	exit
main endp

end main