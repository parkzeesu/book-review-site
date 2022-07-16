// 컬러 모드
const setColorType = (colors) =>{
  for (const [key, value] of Object.entries(colors)){
      document.documentElement.style.setProperty(`--${key}`, `${value}`);
  }
}

const addEventListenerToToggle = ($switch_btn) => {
  $switch_btn.addEventListener("click", (e) => {
      const isDarkMode = e.target.checked
      isDarkMode ? setColorType(darkColors) : setColorType(whiteColors)
  })
}

// IIFE 이용 초기화 함수 선언
const basicInit = (() => {
  const $switch_btn = document.getElementById("switch_btn");
  addEventListenerToToggle($switch_btn)
})()