import{A as t}from"./index.b6666f9f.js";function n(e){return t({url:"/tool/gen/list",method:"get",params:e})}function r(e){return t({url:"/tool/gen/db/list",method:"get",params:e})}function l(e){return t({url:"/tool/gen/"+e,method:"get"})}function u(e){return t({url:"/tool/gen",method:"put",data:e})}function a(e){return t({url:"/tool/gen/importTable",method:"post",params:e})}function s(e){return t({url:"/tool/gen/preview/"+e,method:"get"})}function i(e){return t({url:"/tool/gen/"+e,method:"delete"})}function g(e){return t({url:"/tool/gen/genCode/"+e,method:"get"})}function d(e){return t({url:"/tool/gen/synchDb/"+e,method:"get"})}export{n as a,g as b,i as d,l as g,a as i,r as l,s as p,d as s,u};
