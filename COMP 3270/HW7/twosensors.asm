
INCLUDE Irvine32.inc
.386
.model flat,stdcall
.stack 4096
ExitProcess proto,dwExitCode:dword


.data
	agreeTXT byte "Agree " , 0

	disagreeTXT byte "Disagree " , 0

	actionTXT byte "Take Action " , 0

	values byte 0,0, 50,50, 51,51, 70,-70, -70,-70, 70,70, 1,2, -70, 80, -30,70, 1,1, 9,10, 20, -100, -100, -100, 0, -1


.code
main proc
	mov ecx, lengthof values / 2
	mov esi, 0
	mov edi, 1
	
	value_loop:
			
			; eax contains first value [esi], ebx contains second value [esi + 1 ]
		movsx eax, values[esi]
		call WriteInt
		

		movsx eax, values[esi+1]
		call WriteInt
		call crlf

		movsx eax, values[esi]
		movsx ebx, values[esi+1]
		call sensor
		call crlf
		call crlf

		add esi, 2
		inc edi
	loop value_loop
	exit

main endp

sensor proc uses edx
	mov edx, eax
	sub edx, ebx ; find out if difference btwn sensors are +/- 4	
	cmp edx, 4
	jbe agree
	cmp edx, -4
	jl	disagree

	agree:
		mov edx, offset agreeTXT
		call WriteString
		cmp eax, 50
		jg action
		cmp ebx, 50
		jg action
		jmp break
		action:
			mov edx, offset actionTXT
			call WriteString
			jmp break
		
	disagree:
		mov edx, offset disagreeTXT
		call WriteString
	

break:

	ret
sensor endp

end main