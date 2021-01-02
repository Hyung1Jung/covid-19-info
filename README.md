# covid-19-info

국내 코로나 확진자수를 실시간으로 집계하여 제공 및 지도현황

## 브랜치 관리 전략

&nbsp;&nbsp;&nbsp;&nbsp; Git-Flow 를 이용하여 브랜치를 관리하였습니다.

<p align="center">
  <img src="https://user-images.githubusercontent.com/54772162/101170794-45d27180-3682-11eb-8c42-6f4bf8ec73c9.PNG?raw=true" alt="Sublime's custom image"/>
</p>

✔️ master : 배포시 사용할 브랜치. 초기 시행착오에 의하여 몇몇 기능이 merge 되어 있으나, 원래 사용 용도는 완벽히 배포가 가능한 상태에만 merge가 되어야만 합니다.        
✔️ develop : 다음 버전을 개발하는 브랜치, 완전히 배포가 가능하다고 생각되면 master 브랜치에 merge 합니다.    
✔️ feature : 기능을 개발하는 브랜치    
✔️ release : 배포를 준비할 때 사용할 브랜치    
✔️ hotfix : 배포 후에 발생한 버그를 수정 하는 브랜치


**[참고 및 출처]**

* [우아한형제들 기술블로그](https://woowabros.github.io/experience/2017/10/30/baemin-mobile-git-branch-strategy.html)
* [git-flow cheatsheet](https://danielkummer.github.io/git-flow-cheatsheet/index.ko_KR.html)
