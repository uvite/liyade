import{r as o,v as d,X as m,C as p,D as _,f as n,o as i,c as a,k as h,I as f,e as g}from"./index.4f0e617d.js";const v=["src"],x={__name:"index",props:{src:{type:String,required:!0}},setup(c){const t=c,r=o(document.documentElement.clientHeight-94.5+"px;"),e=o(!0),s=d(()=>t.src);return m(()=>{setTimeout(()=>{e.value=!1},300),window.onresize=function(){r.value=document.documentElement.clientHeight-94.5+"px;"}}),(l,w)=>{const u=p("loading");return _((i(),a("div",{style:f("height:"+n(r))},[h("iframe",{src:n(s),frameborder:"no",style:{width:"100%",height:"100%"},scrolling:"auto"},null,8,v)],4)),[[u,n(e)]])}}},k={__name:"index",setup(c){const t=o("/api/druid/login.html");return(r,e)=>(i(),a("div",null,[g(n(x),{src:t.value,"onUpdate:src":e[0]||(e[0]=s=>t.value=s)},null,8,["src"])]))}};export{k as default};