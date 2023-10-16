// TODO
const IMG_MEME_SRC='img/memee.png'
const IMG_COOKIE_SRC='span'
const BTN_START_ID='button'
const TIMING=15

function main(){
    let temps=TIMING
    let compte=0
    let interval
    function cookie(){
        document.getElementById(IMG_COOKIE_SRC).addEventListener('click',()=>{
            compte++
        });
    }
    function diminuerTemps() {
        if(temps==0){
            clearInterval(interval)    
        }
        document.getElementById(BTN_START_ID).innerHTML=temps
        temps--
    }
    if(temps==TIMING){
        document.getElementById("button").addEventListener('click',()=>{
            interval=setInterval(diminuerTemps, 1000)
            cookie()
        });
    }
}

main()