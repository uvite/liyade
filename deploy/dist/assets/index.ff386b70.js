import{A as h,K as ke,z as Se,r as p,B as ye,C as be,d as i,D as G,o as r,c as T,F as g,G as H,f as t,e as l,w as o,M as K,N as R,j as k,i as Y,m as S,H as J,k as $,x as W,s as ge}from"./index.6afd3664.js";function Ve(s){return h({url:"/app/device/list",method:"get",params:s})}function X(s){return h({url:"/app/device/"+ke(s),method:"get"})}function Ie(s){return h({url:"/app/device",method:"post",data:s})}function he(s){return h({url:"/app/device",method:"put",data:s})}function we(s){return h({url:"/app/device/"+s,method:"delete"})}const Be={class:"app-container"},Te={class:"dialog-footer"},De=Se({name:"Device"}),Ce=Object.assign(De,{setup(s){const{proxy:v}=ge(),{device_status:Z,stock_status:D,product_type:Oe}=v.useDict("device_status","stock_status","product_type"),F=p([]),M=p([]),P=p([]),y=p(!1),O=p(!0),w=p(!0),U=p([]),ee=p(!0),q=p(!0),C=p(0),z=p(""),le=ye({form:{},queryParams:{pageNum:1,pageSize:10,productId:null,supplierId:null,deviceStatus:null,deviceId:null,deviceInStockBy:null,deviceInStockTime:null,deviceOutStockBy:null,deviceOutStockTime:null,stockStatus:null},rules:{}}),{queryParams:u,form:n,rules:te}=be(le);function b(){O.value=!0,Ve(u.value).then(d=>{P.value=d.rows,C.value=d.total,O.value=!1}),X().then(d=>{M.value=d.suppliers,F.value=d.products})}function ae(){y.value=!1,E()}function E(){n.value={id:null,productId:null,supplierId:null,deviceStatus:null,deviceId:null,createBy:null,createTime:null,updateBy:null,updateTime:null,remark:null,deviceInStockBy:null,deviceInStockTime:null,deviceOutStockBy:null,deviceOutStockTime:null,stockStatus:null,deleteBy:null,deleteTime:null,isDeleted:null},v.resetForm("deviceRef")}function I(){u.value.pageNum=1,b()}function oe(){v.resetForm("queryRef"),I()}function ne(d){U.value=d.map(a=>a.id),ee.value=d.length!=1,q.value=!d.length}function ue(d){E();const a=d.id||U.value;X(a).then(f=>{M.value=f.suppliers,F.value=f.products,n.value=f.data,n.value.productId=parseInt(f.data.productId),n.value.supplierId=parseInt(f.data.supplierId),y.value=!0,z.value="\u4FEE\u6539\u8BBE\u5907\u7BA1\u7406"})}function de(){v.$refs.deviceRef.validate(d=>{d&&(n.value.id!=null?he(n.value).then(a=>{v.$modal.msgSuccess("\u4FEE\u6539\u6210\u529F"),y.value=!1,b()}):Ie(n.value).then(a=>{v.$modal.msgSuccess("\u65B0\u589E\u6210\u529F"),y.value=!1,b()}))})}function L(d){const a=d.id||U.value;v.$modal.confirm('\u662F\u5426\u786E\u8BA4\u5220\u9664\u8BBE\u5907\u7BA1\u7406\u7F16\u53F7\u4E3A"'+a+'"\u7684\u6570\u636E\u9879\uFF1F').then(function(){return we(a)}).then(()=>{b(),v.$modal.msgSuccess("\u5220\u9664\u6210\u529F")}).catch(()=>{})}function ie(){v.download("app/device/export",{...u.value},`device_${new Date().getTime()}.xlsx`)}return b(),(d,a)=>{const f=i("el-option"),x=i("el-select"),c=i("el-form-item"),V=i("el-input"),_=i("el-button"),Q=i("el-form"),j=i("el-col"),ce=i("right-toolbar"),re=i("el-row"),m=i("el-table-column"),pe=i("el-switch"),se=i("dict-tag"),me=i("el-table"),ve=i("pagination"),A=i("el-date-picker"),fe=i("el-dialog"),B=G("hasPermi"),_e=G("loading");return r(),T("div",Be,[g(l(Q,{model:t(u),ref:"queryRef",inline:!0,"label-width":"68px"},{default:o(()=>[l(c,{label:"\u8BBE\u5907\u72B6\u6001",prop:"deviceStatus"},{default:o(()=>[l(x,{modelValue:t(u).deviceStatus,"onUpdate:modelValue":a[0]||(a[0]=e=>t(u).deviceStatus=e),placeholder:"\u8BF7\u9009\u62E9\u8BBE\u5907\u72B6\u6001",clearable:""},{default:o(()=>[(r(!0),T(K,null,R(t(Z),e=>(r(),k(f,{key:e.value,label:e.label,value:e.value},null,8,["label","value"]))),128))]),_:1},8,["modelValue"])]),_:1}),l(c,{label:"\u7F16\u53F7",prop:"deviceId"},{default:o(()=>[l(V,{modelValue:t(u).deviceId,"onUpdate:modelValue":a[1]||(a[1]=e=>t(u).deviceId=e),placeholder:"\u8BF7\u8F93\u5165\u7F16\u53F7",clearable:"",onKeyup:Y(I,["enter"])},null,8,["modelValue","onKeyup"])]),_:1}),l(c,{label:"\u5165\u5E93\u4EBA",prop:"deviceInStockBy"},{default:o(()=>[l(V,{modelValue:t(u).deviceInStockBy,"onUpdate:modelValue":a[2]||(a[2]=e=>t(u).deviceInStockBy=e),placeholder:"\u8BF7\u8F93\u5165\u5165\u5E93\u4EBA",clearable:"",onKeyup:Y(I,["enter"])},null,8,["modelValue","onKeyup"])]),_:1}),l(c,{label:"\u51FA\u5E93\u4EBA",prop:"deviceOutStockBy"},{default:o(()=>[l(V,{modelValue:t(u).deviceOutStockBy,"onUpdate:modelValue":a[3]||(a[3]=e=>t(u).deviceOutStockBy=e),placeholder:"\u8BF7\u8F93\u5165\u51FA\u5E93\u4EBA",clearable:"",onKeyup:Y(I,["enter"])},null,8,["modelValue","onKeyup"])]),_:1}),l(c,{label:"\u72B6\u6001",prop:"stockStatus"},{default:o(()=>[l(x,{modelValue:t(u).stockStatus,"onUpdate:modelValue":a[4]||(a[4]=e=>t(u).stockStatus=e),placeholder:"\u8BF7\u9009\u62E9\u72B6\u6001",clearable:""},{default:o(()=>[(r(!0),T(K,null,R(t(D),e=>(r(),k(f,{key:e.value,label:e.label,value:e.value},null,8,["label","value"]))),128))]),_:1},8,["modelValue"])]),_:1}),l(c,null,{default:o(()=>[l(_,{type:"primary",icon:"Search",onClick:I},{default:o(()=>[S("\u641C\u7D22")]),_:1}),l(_,{icon:"Refresh",onClick:oe},{default:o(()=>[S("\u91CD\u7F6E")]),_:1})]),_:1})]),_:1},8,["model"]),[[H,t(w)]]),l(re,{gutter:10,class:"mb8"},{default:o(()=>[l(j,{span:1.5},{default:o(()=>[g((r(),k(_,{type:"danger",plain:"",icon:"Delete",disabled:t(q),onClick:L},{default:o(()=>[S("\u5220\u9664")]),_:1},8,["disabled"])),[[B,["app:device:remove"]]])]),_:1},8,["span"]),l(j,{span:1.5},{default:o(()=>[g((r(),k(_,{type:"warning",plain:"",icon:"Download",onClick:ie},{default:o(()=>[S("\u5BFC\u51FA")]),_:1})),[[B,["app:device:export"]]])]),_:1},8,["span"]),l(ce,{showSearch:t(w),"onUpdate:showSearch":a[5]||(a[5]=e=>J(w)?w.value=e:null),onQueryTable:b},null,8,["showSearch"])]),_:1}),g((r(),k(me,{data:t(P),onSelectionChange:ne},{default:o(()=>[l(m,{type:"selection",width:"55",align:"center"}),l(m,{label:"\u8BBE\u5907\u7F16\u53F7",align:"center",prop:"deviceId"}),l(m,{label:"\u4EA7\u54C1\u578B\u53F7",align:"center",prop:"product.productName"}),l(m,{label:"\u8BBE\u5907\u6388\u6743",align:"center"},{default:o(e=>[l(pe,{modelValue:e.row.used,"onUpdate:modelValue":N=>e.row.used=N,"active-value":"1","inactive-value":"0",disabled:"true"},null,8,["modelValue","onUpdate:modelValue"])]),_:1}),l(m,{label:"\u5165\u5E93\u65F6\u95F4",align:"center",prop:"deviceInStockTime",width:"180"},{default:o(e=>[$("span",null,W(d.parseTime(e.row.deviceInStockTime,"{y}-{m}-{d}")),1)]),_:1}),l(m,{label:"\u5165\u5E93\u4EBA",align:"center",prop:"deviceInStockBy"}),l(m,{label:"\u51FA\u5E93\u65F6\u95F4",align:"center",prop:"deviceOutStockTime",width:"180"},{default:o(e=>[$("span",null,W(d.parseTime(e.row.deviceOutStockTime,"{y}-{m}-{d}")),1)]),_:1}),l(m,{label:"\u51FA\u5E93\u4EBA",align:"center",prop:"deviceOutStockBy"}),l(m,{label:"\u5B58\u8D27\u72B6\u6001",align:"center",prop:"stockStatus"},{default:o(e=>[l(se,{options:t(D),value:e.row.stockStatus},null,8,["options","value"])]),_:1}),l(m,{label:"\u64CD\u4F5C",align:"center","class-name":"small-padding fixed-width"},{default:o(e=>[g((r(),k(_,{link:"",type:"primary",icon:"Edit",onClick:N=>ue(e.row)},{default:o(()=>[S("\u51FA\u5165\u5E93\u660E\u7EC6")]),_:2},1032,["onClick"])),[[B,["app:device:edit"]]]),g((r(),k(_,{link:"",type:"primary",icon:"Delete",onClick:N=>L(e.row)},{default:o(()=>[S("\u5220\u9664")]),_:2},1032,["onClick"])),[[B,["app:device:remove"]]])]),_:1})]),_:1},8,["data"])),[[_e,t(O)]]),g(l(ve,{total:t(C),page:t(u).pageNum,"onUpdate:page":a[6]||(a[6]=e=>t(u).pageNum=e),limit:t(u).pageSize,"onUpdate:limit":a[7]||(a[7]=e=>t(u).pageSize=e),onPagination:b},null,8,["total","page","limit"]),[[H,t(C)>0]]),l(fe,{title:t(z),modelValue:t(y),"onUpdate:modelValue":a[14]||(a[14]=e=>J(y)?y.value=e:null),width:"500px","append-to-body":""},{footer:o(()=>[$("div",Te,[l(_,{type:"primary",onClick:de},{default:o(()=>[S("\u786E \u5B9A")]),_:1}),l(_,{onClick:ae},{default:o(()=>[S("\u53D6 \u6D88")]),_:1})])]),default:o(()=>[l(Q,{ref:"deviceRef",model:t(n),rules:t(te),"label-width":"80px"},{default:o(()=>[l(c,{label:"\u8BBE\u5907\u7F16\u53F7",prop:"deviceId"},{default:o(()=>[l(V,{modelValue:t(n).deviceId,"onUpdate:modelValue":a[8]||(a[8]=e=>t(n).deviceId=e),placeholder:"\u8BF7\u8F93\u5165\u8BBE\u5907\u7F16\u53F7"},null,8,["modelValue"])]),_:1}),l(c,{label:"\u5165\u5E93\u4EBA",prop:"deviceInStockBy"},{default:o(()=>[l(V,{modelValue:t(n).deviceInStockBy,"onUpdate:modelValue":a[9]||(a[9]=e=>t(n).deviceInStockBy=e),placeholder:"\u8BF7\u8F93\u5165\u5165\u5E93\u4EBA"},null,8,["modelValue"])]),_:1}),l(c,{label:"\u5165\u5E93\u65F6\u95F4",prop:"deviceInStockTime"},{default:o(()=>[l(A,{clearable:"",modelValue:t(n).deviceInStockTime,"onUpdate:modelValue":a[10]||(a[10]=e=>t(n).deviceInStockTime=e),type:"date","value-format":"YYYY-MM-DD",placeholder:"\u8BF7\u9009\u62E9\u5165\u5E93\u65F6\u95F4"},null,8,["modelValue"])]),_:1}),l(c,{label:"\u51FA\u5E93\u4EBA",prop:"deviceOutStockBy"},{default:o(()=>[l(V,{modelValue:t(n).deviceOutStockBy,"onUpdate:modelValue":a[11]||(a[11]=e=>t(n).deviceOutStockBy=e),placeholder:"\u8BF7\u8F93\u5165\u51FA\u5E93\u4EBA"},null,8,["modelValue"])]),_:1}),l(c,{label:"\u51FA\u5E93\u65F6\u95F4",prop:"deviceOutStockTime"},{default:o(()=>[l(A,{clearable:"",modelValue:t(n).deviceOutStockTime,"onUpdate:modelValue":a[12]||(a[12]=e=>t(n).deviceOutStockTime=e),type:"date","value-format":"YYYY-MM-DD",placeholder:"\u8BF7\u9009\u62E9\u51FA\u5E93\u65F6\u95F4"},null,8,["modelValue"])]),_:1}),l(c,{label:"\u72B6\u6001",prop:"stockStatus"},{default:o(()=>[l(x,{modelValue:t(n).stockStatus,"onUpdate:modelValue":a[13]||(a[13]=e=>t(n).stockStatus=e),placeholder:"\u8BF7\u9009\u62E9\u72B6\u6001"},{default:o(()=>[(r(!0),T(K,null,R(t(D),e=>(r(),k(f,{key:e.value,label:e.label,value:e.value},null,8,["label","value"]))),128))]),_:1},8,["modelValue"])]),_:1})]),_:1},8,["model","rules"])]),_:1},8,["title","modelValue"])])}}});export{Ce as default};
