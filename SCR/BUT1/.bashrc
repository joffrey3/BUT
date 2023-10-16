echo "Hello $USER. Your home is $HOME"
alias rm="rm -i"
alias la="la -al"
alias lx="lx -lXB"
alias lr="lr -lR"
alias du="du -kh"
alias df="df -kTh"
alias cp="cp -i"
alias mv="mv -i"
function GetInfo()
{
	echo "You are logged on $(hostname)"
	echo "Additionnal information : " ; uname -a
	echo "Users logged on " ; w -h
	echo "Current date : " ; date 
	echo "Machine stats : " ; uptime
	echo "Memory stats : " ; free
}


