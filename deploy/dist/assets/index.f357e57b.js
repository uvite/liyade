import{A as w,K as se,z as me,r as f,B as fe,C as _e,d as p,D as G,o as d,c as N,F as b,G as H,f as t,e as l,w as a,i as T,M as F,N as q,j as _,m as v,H as M,k as ve,s as ye}from"./index.b6666f9f.js";function be(s){return w({url:"/app/product/list",method:"get",params:s})}function J(s){return w({url:"/app/product/"+se(s),method:"get"})}function ge(s){return w({url:"/app/product",method:"post",data:s})}function Ve(s){return w({url:"/app/product",method:"put",data:s})}function Ce(s){return w({url:"/app/product/"+s,method:"delete"})}const he={class:"app-container"},ke={class:"dialog-footer"},we=me({name:"Product"}),Se=Object.assign(we,{setup(s){const{proxy:y}=ye(),{product_type:U}=y.useDict("product_type"),x=f([]),z=f([]),g=f(!1),I=f(!0),P=f(!0),K=f([]),L=f(!0),Q=f(!0),D=f(0),R=f(""),W=fe({form:{},queryParams:{pageNum:1,pageSize:20,productName:null,productType:null,productSupplierCode:null,productCode:null,productPrice:null,productCreateTime:null},rules:{}}),{queryParams:n,form:u,rules:X}=_e(W);function V(){I.value=!0,be(n.value).then(r=>{z.value=r.rows,D.value=r.total,I.value=!1})}function Y(){g.value=!1,$()}function $(){u.value={productId:null,productName:null,productType:null,productSupplierCode:null,productCode:null,productPrice:null,productCreateTime:null,createBy:null,createTime:null,updateBy:null,updateTime:null,remark:null},y.resetForm("productRef")}function h(){n.value.pageNum=1,V()}function Z(){y.resetForm("queryRef"),h()}function ee(r){K.value=r.map(o=>o.productId),L.value=r.length!=1,Q.value=!r.length}function le(){$(),J().then(r=>{x.value=r.suppliers,g.value=!0,R.value="\u6DFB\u52A0\u4EA7\u54C1\u7BA1\u7406"})}async function j(r){$();const o=r.productId||K.value;J(o).then(async c=>{x.value=c.suppliers,u.value=c.data,u.value.supplierId=parseInt(c.data.supplierId),g.value=!0,R.value="\u4FEE\u6539\u4EA7\u54C1\u7BA1\u7406"})}function te(){y.$refs.productRef.validate(r=>{r&&(u.value.productId!=null?Ve(u.value).then(o=>{y.$modal.msgSuccess("\u4FEE\u6539\u6210\u529F"),g.value=!1,V()}):ge(u.value).then(o=>{y.$modal.msgSuccess("\u65B0\u589E\u6210\u529F"),g.value=!1,V()}))})}function A(r){const o=r.productId||K.value;y.$modal.confirm('\u662F\u5426\u786E\u8BA4\u5220\u9664\u4EA7\u54C1\u7BA1\u7406\u7F16\u53F7\u4E3A"'+o+'"\u7684\u6570\u636E\u9879\uFF1F').then(function(){return Ce(o)}).then(()=>{V(),y.$modal.msgSuccess("\u5220\u9664\u6210\u529F")}).catch(()=>{})}function oe(){y.download("app/product/export",{...n.value},`product_${new Date().getTime()}.xlsx`)}return V(),(r,o)=>{const c=p("el-input"),i=p("el-form-item"),B=p("el-option"),E=p("el-select"),m=p("el-button"),O=p("el-form"),S=p("el-col"),ae=p("right-toolbar"),ue=p("el-row"),C=p("el-table-column"),ne=p("dict-tag"),re=p("el-table"),pe=p("pagination"),de=p("el-dialog"),k=G("hasPermi"),ce=G("loading");return d(),N("div",he,[b(l(O,{model:t(n),ref:"queryRef",inline:!0,"label-width":"68px"},{default:a(()=>[l(i,{label:"\u540D\u79F0",prop:"productName"},{default:a(()=>[l(c,{modelValue:t(n).productName,"onUpdate:modelValue":o[0]||(o[0]=e=>t(n).productName=e),placeholder:"\u8BF7\u8F93\u5165\u540D\u79F0",clearable:"",onKeyup:T(h,["enter"])},null,8,["modelValue","onKeyup"])]),_:1}),l(i,{label:`\u7C7B\u578B\r
`,prop:"productType"},{default:a(()=>[l(E,{modelValue:t(n).productType,"onUpdate:modelValue":o[1]||(o[1]=e=>t(n).productType=e),placeholder:`\u8BF7\u9009\u62E9\u7C7B\u578B\r
`,clearable:""},{default:a(()=>[(d(!0),N(F,null,q(t(U),e=>(d(),_(B,{key:e.value,label:e.label,value:e.value},null,8,["label","value"]))),128))]),_:1},8,["modelValue"])]),_:1}),l(i,{label:`\u4F9B\u5E94\u5546\r
`,prop:"productSupplierCode"},{default:a(()=>[l(c,{modelValue:t(n).productSupplierCode,"onUpdate:modelValue":o[2]||(o[2]=e=>t(n).productSupplierCode=e),placeholder:`\u8BF7\u8F93\u5165\u4F9B\u5E94\u5546\r
`,clearable:"",onKeyup:T(h,["enter"])},null,8,["modelValue","onKeyup"])]),_:1}),l(i,{label:`\u4EA7\u54C1\u7F16\u53F7\r
`,prop:"productCode"},{default:a(()=>[l(c,{modelValue:t(n).productCode,"onUpdate:modelValue":o[3]||(o[3]=e=>t(n).productCode=e),placeholder:`\u8BF7\u8F93\u5165\u4EA7\u54C1\u7F16\u53F7\r
`,clearable:"",onKeyup:T(h,["enter"])},null,8,["modelValue","onKeyup"])]),_:1}),l(i,{label:"\u53C2\u8003\u4EF7\u683C",prop:"productPrice"},{default:a(()=>[l(c,{modelValue:t(n).productPrice,"onUpdate:modelValue":o[4]||(o[4]=e=>t(n).productPrice=e),placeholder:"\u8BF7\u8F93\u5165\u53C2\u8003\u4EF7\u683C",clearable:"",onKeyup:T(h,["enter"])},null,8,["modelValue","onKeyup"])]),_:1}),l(i,null,{default:a(()=>[l(m,{type:"primary",icon:"Search",onClick:h},{default:a(()=>[v("\u641C\u7D22")]),_:1}),l(m,{icon:"Refresh",onClick:Z},{default:a(()=>[v("\u91CD\u7F6E")]),_:1})]),_:1})]),_:1},8,["model"]),[[H,t(P)]]),l(ue,{gutter:10,class:"mb8"},{default:a(()=>[l(S,{span:1.5},{default:a(()=>[b((d(),_(m,{type:"primary",plain:"",icon:"Plus",onClick:le},{default:a(()=>[v("\u65B0\u589E ")]),_:1})),[[k,["app:product:add"]]])]),_:1},8,["span"]),l(S,{span:1.5},{default:a(()=>[b((d(),_(m,{type:"success",plain:"",icon:"Edit",disabled:t(L),onClick:j},{default:a(()=>[v("\u4FEE\u6539 ")]),_:1},8,["disabled"])),[[k,["app:product:edit"]]])]),_:1},8,["span"]),l(S,{span:1.5},{default:a(()=>[b((d(),_(m,{type:"danger",plain:"",icon:"Delete",disabled:t(Q),onClick:A},{default:a(()=>[v("\u5220\u9664 ")]),_:1},8,["disabled"])),[[k,["app:product:remove"]]])]),_:1},8,["span"]),l(S,{span:1.5},{default:a(()=>[b((d(),_(m,{type:"warning",plain:"",icon:"Download",onClick:oe},{default:a(()=>[v("\u5BFC\u51FA ")]),_:1})),[[k,["app:product:export"]]])]),_:1},8,["span"]),l(ae,{showSearch:t(P),"onUpdate:showSearch":o[5]||(o[5]=e=>M(P)?P.value=e:null),onQueryTable:V},null,8,["showSearch"])]),_:1}),b((d(),_(re,{data:t(z),onSelectionChange:ee},{default:a(()=>[l(C,{type:"selection",width:"55",align:"center"}),l(C,{label:"\u578B\u53F7\u540D\u79F0",align:"center",prop:"productName"}),l(C,{label:"\u578B\u53F7\u7F16\u53F7",align:"center",prop:"productCode"}),l(C,{label:"\u53C2\u8003\u4EF7\u683C",align:"center",prop:"productPrice"}),l(C,{label:"\u4F9B\u5E94\u5546",align:"center",prop:"supplier.supplierName"}),l(C,{label:"\u7C7B\u578B",align:"center",prop:"productType"},{default:a(e=>[l(ne,{options:t(U),value:e.row.productType},null,8,["options","value"])]),_:1}),l(C,{label:"\u64CD\u4F5C",align:"center","class-name":"small-padding fixed-width"},{default:a(e=>[b((d(),_(m,{link:"",type:"primary",icon:"Edit",onClick:ie=>j(e.row)},{default:a(()=>[v(" \u4FEE\u6539 ")]),_:2},1032,["onClick"])),[[k,["app:product:edit"]]]),b((d(),_(m,{link:"",type:"primary",icon:"Delete",onClick:ie=>A(e.row)},{default:a(()=>[v("\u5220\u9664 ")]),_:2},1032,["onClick"])),[[k,["app:product:remove"]]])]),_:1})]),_:1},8,["data"])),[[ce,t(I)]]),b(l(pe,{total:t(D),page:t(n).pageNum,"onUpdate:page":o[6]||(o[6]=e=>t(n).pageNum=e),limit:t(n).pageSize,"onUpdate:limit":o[7]||(o[7]=e=>t(n).pageSize=e),onPagination:V},null,8,["total","page","limit"]),[[H,t(D)>0]]),l(de,{title:t(R),modelValue:t(g),"onUpdate:modelValue":o[14]||(o[14]=e=>M(g)?g.value=e:null),width:"500px","append-to-body":""},{footer:a(()=>[ve("div",ke,[l(m,{type:"primary",onClick:te},{default:a(()=>[v("\u786E \u5B9A")]),_:1}),l(m,{onClick:Y},{default:a(()=>[v("\u53D6 \u6D88")]),_:1})])]),default:a(()=>[l(O,{ref:"productRef",model:t(u),rules:t(X),"label-width":"80px"},{default:a(()=>[l(i,{label:"\u540D\u79F0",prop:"productName"},{default:a(()=>[l(c,{modelValue:t(u).productName,"onUpdate:modelValue":o[8]||(o[8]=e=>t(u).productName=e),placeholder:"\u8BF7\u8F93\u5165\u540D\u79F0"},null,8,["modelValue"])]),_:1}),l(i,{label:"\u7C7B\u578B",prop:"productType"},{default:a(()=>[l(E,{modelValue:t(u).productType,"onUpdate:modelValue":o[9]||(o[9]=e=>t(u).productType=e),placeholder:`\u8BF7\u9009\u62E9\u7C7B\u578B\r
`},{default:a(()=>[(d(!0),N(F,null,q(t(U),e=>(d(),_(B,{key:e.value,label:e.label,value:e.value},null,8,["label","value"]))),128))]),_:1},8,["modelValue"])]),_:1}),l(i,{label:"\u4F9B\u5E94\u5546",prop:"productSupplierCode"},{default:a(()=>[l(E,{modelValue:t(u).supplierId,"onUpdate:modelValue":o[10]||(o[10]=e=>t(u).supplierId=e),placeholder:"\u8BF7\u9009\u62E9"},{default:a(()=>[(d(!0),N(F,null,q(t(x),e=>(d(),_(B,{key:e.supplierId,label:e.supplierName,value:e.supplierId,disabled:e.status==1},null,8,["label","value","disabled"]))),128))]),_:1},8,["modelValue"])]),_:1}),l(i,{label:"\u4EA7\u54C1\u7F16\u53F7",prop:"productCode"},{default:a(()=>[l(c,{modelValue:t(u).productCode,"onUpdate:modelValue":o[11]||(o[11]=e=>t(u).productCode=e),placeholder:"\u8BF7\u8F93\u5165\u4EA7\u54C1\u7F16\u53F7"},null,8,["modelValue"])]),_:1}),l(i,{label:"\u53C2\u8003\u4EF7\u683C",prop:"productPrice"},{default:a(()=>[l(c,{modelValue:t(u).productPrice,"onUpdate:modelValue":o[12]||(o[12]=e=>t(u).productPrice=e),placeholder:"\u8BF7\u8F93\u5165\u53C2\u8003\u4EF7\u683C"},null,8,["modelValue"])]),_:1}),l(i,{label:"\u5907\u6CE8",prop:"remark"},{default:a(()=>[l(c,{modelValue:t(u).remark,"onUpdate:modelValue":o[13]||(o[13]=e=>t(u).remark=e),type:"textarea",placeholder:"\u8BF7\u8F93\u5165\u5185\u5BB9"},null,8,["modelValue"])]),_:1})]),_:1},8,["model","rules"])]),_:1},8,["title","modelValue"])])}}});export{Se as default};
