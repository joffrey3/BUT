function c=code2char(code)
	c=ascii(code + ascii('a') -1)
endfunction
function code=char2code(c)
	code=ascii(c) - ascii('a') + 1
endfunction
function [A,B,i]=partage(I)
	// TODO
endfunction
function joue()
  printf("\nChoisissez le nom d''un animal...\n\n");
  n = size(mat,'c')
  I = ([1:n]>0)
  //I=ones(1,n)
  while sum(I)>1 do
    [A,B,i]=partage(I)
    printf("Ce mot contient-il la lettre %c ? [o/n] \n",code2char(i))
    c = scanf("%s")
    if c=='o' then I=A, else I=B, end
  end
  printf("L''animal est un(e) %s\n\n",noms(I))
endfunction
function arbre(I,str)
  if (sum(I)>1) then
    [A,B,i]=partage(I);
    arbre(A,str+'| ');
    printf("%s%c (%i,%i)\n",str,ascii(i+96),sum(A),sum(B));
    arbre(B,str+'| ');
  else
    printf("%s -> %s\n",str,noms(I));
  end
endfunction
exec('animaux.dat')
n=size(noms,'r')
mat=zeros(26,n);
for i=1:n
  c=char2code(noms(i))
  mat(c,i) = 1;
end