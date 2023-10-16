        .section .text
        .globl lire
        .type lire, @function
lire:
.LFB0:
	      .cfi_startproc
	      pushq	%rbp
	      .cfi_def_cfa_offset 16
	      .cfi_offset 6, -16
	      movq	%rsp, %rbp
	      .cfi_def_cfa_register 6

        xorq %rdx, %rdx
        movl %esi, %edx               # taille max
        movq %rdi, %rsi               # adresse chaine
        movq $0, %rax                 # read
        movq $0, %rdi                 # stdin
        decq %rdx                     # place du \0
        syscall                       # call read
        cmpb $10, -1(%rsi, %rax, 1)   # si \n
        jne lire_1
        decq %rax
lire_1: movb $0, (%rsi, %rax, 1)      # place \0

	      popq	%rbp
	      .cfi_def_cfa 7, 8
	      ret
	      .cfi_endproc
.LFE0:
	      .size	lire, .-lire
