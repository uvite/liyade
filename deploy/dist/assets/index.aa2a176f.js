import{A as O,K as ke,z as ye,r as m,B as Se,C as Ve,d as i,D as X,o as d,c as y,F as S,G as Z,f as t,e as l,w as a,M as I,N as w,j as c,i as q,m as _,H as ee,k as z,x as le,s as ge}from"./index.ac5e8359.js";function Ie(f){return O({url:"/app/device/list",method:"get",params:f})}function L(f){return O({url:"/app/device/"+ke(f),method:"get"})}function we(f){return O({url:"/app/device",method:"post",data:f})}function Ce(f){return O({url:"/app/device",method:"put",data:f})}function he(f){return O({url:"/app/device/"+f,method:"delete"})}const Be={class:"app-container"},Te={class:"dialog-footer"},Ue=ye({name:"Device"}),Oe=Object.assign(Ue,{setup(f){const{proxy:k}=ge(),{device_status:K,stock_status:R,product_type:te}=k.useDict("device_status","stock_status","product_type"),T=m([]),U=m([]),Q=m([]),V=m(!1),Y=m(!0),x=m(!0),$=m([]),j=m(!0),A=m(!0),P=m(0),E=m(""),ae=Se({form:{},queryParams:{pageNum:1,pageSize:10,productId:null,supplierId:null,deviceStatus:null,deviceCode:null,deviceInStockBy:null,deviceInStockTime:null,deviceOutStockBy:null,deviceOutStockTime:null,stockStatus:null},rules:{}}),{queryParams:n,form:u,rules:oe}=Ve(ae);function C(){Y.value=!0,Ie(n.value).then(p=>{Q.value=p.rows,P.value=p.total,Y.value=!1}),L().then(p=>{U.value=p.suppliers,T.value=p.products})}function ue(){V.value=!1,F()}function F(){u.value={deviceId:null,productId:null,supplierId:null,deviceStatus:null,deviceCode:null,createBy:null,createTime:null,updateBy:null,updateTime:null,remark:null,deviceInStockBy:null,deviceInStockTime:null,deviceOutStockBy:null,deviceOutStockTime:null,stockStatus:null,deleteBy:null,deleteTime:null,isDeleted:null},k.resetForm("deviceRef")}function D(){n.value.pageNum=1,C()}function de(){k.resetForm("queryRef"),D()}function ne(p){$.value=p.map(o=>o.deviceId),j.value=p.length!=1,A.value=!p.length}function pe(){F(),L().then(p=>{U.value=p.suppliers,T.value=p.products,V.value=!0,E.value="\u6DFB\u52A0\u8BBE\u5907\u7BA1\u7406"})}function G(p){F();const o=p.deviceId||$.value;L(o).then(s=>{U.value=s.suppliers,T.value=s.products,u.value=s.data,u.value.productId=parseInt(s.data.productId),u.value.supplierId=parseInt(s.data.supplierId),V.value=!0,E.value="\u4FEE\u6539\u8BBE\u5907\u7BA1\u7406"})}function re(){k.$refs.deviceRef.validate(p=>{p&&(u.value.deviceId!=null?Ce(u.value).then(o=>{k.$modal.msgSuccess("\u4FEE\u6539\u6210\u529F"),V.value=!1,C()}):we(u.value).then(o=>{k.$modal.msgSuccess("\u65B0\u589E\u6210\u529F"),V.value=!1,C()}))})}function H(p){const o=p.deviceId||$.value;k.$modal.confirm('\u662F\u5426\u786E\u8BA4\u5220\u9664\u8BBE\u5907\u7BA1\u7406\u7F16\u53F7\u4E3A"'+o+'"\u7684\u6570\u636E\u9879\uFF1F').then(function(){return he(o)}).then(()=>{C(),k.$modal.msgSuccess("\u5220\u9664\u6210\u529F")}).catch(()=>{})}function ie(){k.download("app/device/export",{...n.value},`device_${new Date().getTime()}.xlsx`)}return C(),(p,o)=>{const s=i("el-option"),g=i("el-select"),r=i("el-form-item"),h=i("el-input"),b=i("el-button"),J=i("el-form"),N=i("el-col"),ce=i("right-toolbar"),se=i("el-row"),v=i("el-table-column"),M=i("dict-tag"),ve=i("el-table"),me=i("pagination"),W=i("el-date-picker"),fe=i("el-dialog"),B=X("hasPermi"),be=X("loading");return d(),y("div",Be,[S(l(J,{model:t(n),ref:"queryRef",inline:!0,"label-width":"68px"},{default:a(()=>[l(r,{label:"\u4EA7\u54C1\u540D\u79F0",prop:"productId"},{default:a(()=>[l(g,{modelValue:t(n).productId,"onUpdate:modelValue":o[0]||(o[0]=e=>t(n).productId=e),placeholder:"\u8BF7\u8F93\u5165\u4EA7\u54C1\u578B\u53F7"},{default:a(()=>[(d(!0),y(I,null,w(t(T),e=>(d(),c(s,{key:e.productId,label:e.productName,value:e.productId,disabled:e.status==1},null,8,["label","value","disabled"]))),128))]),_:1},8,["modelValue"])]),_:1}),l(r,{label:"\u4F9B\u5E94\u5546",prop:"supplierId"},{default:a(()=>[l(g,{modelValue:t(n).supplierId,"onUpdate:modelValue":o[1]||(o[1]=e=>t(n).supplierId=e),placeholder:"\u8BF7\u9009\u62E9"},{default:a(()=>[(d(!0),y(I,null,w(t(U),e=>(d(),c(s,{key:e.supplierId,label:e.supplierName,value:e.supplierId,disabled:e.status==1},null,8,["label","value","disabled"]))),128))]),_:1},8,["modelValue"])]),_:1}),l(r,{label:"\u8BBE\u5907\u72B6\u6001",prop:"deviceStatus"},{default:a(()=>[l(g,{modelValue:t(n).deviceStatus,"onUpdate:modelValue":o[2]||(o[2]=e=>t(n).deviceStatus=e),placeholder:"\u8BF7\u9009\u62E9\u8BBE\u5907\u72B6\u6001",clearable:""},{default:a(()=>[(d(!0),y(I,null,w(t(K),e=>(d(),c(s,{key:e.value,label:e.label,value:e.value},null,8,["label","value"]))),128))]),_:1},8,["modelValue"])]),_:1}),l(r,{label:"\u7F16\u53F7",prop:"deviceCode"},{default:a(()=>[l(h,{modelValue:t(n).deviceCode,"onUpdate:modelValue":o[3]||(o[3]=e=>t(n).deviceCode=e),placeholder:"\u8BF7\u8F93\u5165\u7F16\u53F7",clearable:"",onKeyup:q(D,["enter"])},null,8,["modelValue","onKeyup"])]),_:1}),l(r,{label:"\u5165\u5E93\u4EBA",prop:"deviceInStockBy"},{default:a(()=>[l(h,{modelValue:t(n).deviceInStockBy,"onUpdate:modelValue":o[4]||(o[4]=e=>t(n).deviceInStockBy=e),placeholder:"\u8BF7\u8F93\u5165\u5165\u5E93\u4EBA",clearable:"",onKeyup:q(D,["enter"])},null,8,["modelValue","onKeyup"])]),_:1}),l(r,{label:"\u51FA\u5E93\u4EBA",prop:"deviceOutStockBy"},{default:a(()=>[l(h,{modelValue:t(n).deviceOutStockBy,"onUpdate:modelValue":o[5]||(o[5]=e=>t(n).deviceOutStockBy=e),placeholder:"\u8BF7\u8F93\u5165\u51FA\u5E93\u4EBA",clearable:"",onKeyup:q(D,["enter"])},null,8,["modelValue","onKeyup"])]),_:1}),l(r,{label:"\u72B6\u6001",prop:"stockStatus"},{default:a(()=>[l(g,{modelValue:t(n).stockStatus,"onUpdate:modelValue":o[6]||(o[6]=e=>t(n).stockStatus=e),placeholder:"\u8BF7\u9009\u62E9\u72B6\u6001",clearable:""},{default:a(()=>[(d(!0),y(I,null,w(t(R),e=>(d(),c(s,{key:e.value,label:e.label,value:e.value},null,8,["label","value"]))),128))]),_:1},8,["modelValue"])]),_:1}),l(r,null,{default:a(()=>[l(b,{type:"primary",icon:"Search",onClick:D},{default:a(()=>[_("\u641C\u7D22")]),_:1}),l(b,{icon:"Refresh",onClick:de},{default:a(()=>[_("\u91CD\u7F6E")]),_:1})]),_:1})]),_:1},8,["model"]),[[Z,t(x)]]),l(se,{gutter:10,class:"mb8"},{default:a(()=>[l(N,{span:1.5},{default:a(()=>[S((d(),c(b,{type:"primary",plain:"",icon:"Plus",onClick:pe},{default:a(()=>[_("\u65B0\u589E")]),_:1})),[[B,["app:device:add"]]])]),_:1},8,["span"]),l(N,{span:1.5},{default:a(()=>[S((d(),c(b,{type:"success",plain:"",icon:"Edit",disabled:t(j),onClick:G},{default:a(()=>[_("\u4FEE\u6539")]),_:1},8,["disabled"])),[[B,["app:device:edit"]]])]),_:1},8,["span"]),l(N,{span:1.5},{default:a(()=>[S((d(),c(b,{type:"danger",plain:"",icon:"Delete",disabled:t(A),onClick:H},{default:a(()=>[_("\u5220\u9664")]),_:1},8,["disabled"])),[[B,["app:device:remove"]]])]),_:1},8,["span"]),l(N,{span:1.5},{default:a(()=>[S((d(),c(b,{type:"warning",plain:"",icon:"Download",onClick:ie},{default:a(()=>[_("\u5BFC\u51FA")]),_:1})),[[B,["app:device:export"]]])]),_:1},8,["span"]),l(ce,{showSearch:t(x),"onUpdate:showSearch":o[7]||(o[7]=e=>ee(x)?x.value=e:null),onQueryTable:C},null,8,["showSearch"])]),_:1}),S((d(),c(ve,{data:t(Q),onSelectionChange:ne},{default:a(()=>[l(v,{type:"selection",width:"55",align:"center"}),l(v,{label:"\u8BBE\u5907\u7F16\u53F7",align:"center",prop:"deviceCode"}),l(v,{label:"\u4EA7\u54C1\u578B\u53F7",align:"center",prop:"product.productName"}),l(v,{label:"\u4EA7\u54C1\u7C7B\u578B",align:"center",prop:"product.productType"},{default:a(e=>[l(M,{options:t(te),value:e.row.product.productType},null,8,["options","value"])]),_:1}),l(v,{label:"\u8BBE\u5907\u6388\u6743",align:"center",prop:"deviceStatus"},{default:a(e=>[l(M,{options:t(K),value:e.row.deviceStatus},null,8,["options","value"])]),_:1}),l(v,{label:"\u5165\u5E93\u65F6\u95F4",align:"center",prop:"deviceInStockTime",width:"180"},{default:a(e=>[z("span",null,le(p.parseTime(e.row.deviceInStockTime,"{y}-{m}-{d}")),1)]),_:1}),l(v,{label:"\u5165\u5E93\u4EBA",align:"center",prop:"deviceInStockBy"}),l(v,{label:"\u51FA\u5E93\u65F6\u95F4",align:"center",prop:"deviceOutStockTime",width:"180"},{default:a(e=>[z("span",null,le(p.parseTime(e.row.deviceOutStockTime,"{y}-{m}-{d}")),1)]),_:1}),l(v,{label:"\u51FA\u5E93\u4EBA",align:"center",prop:"deviceOutStockBy"}),l(v,{label:"\u5B58\u8D27\u72B6\u6001",align:"center",prop:"stockStatus"},{default:a(e=>[l(M,{options:t(R),value:e.row.stockStatus},null,8,["options","value"])]),_:1}),l(v,{label:"\u64CD\u4F5C",align:"center","class-name":"small-padding fixed-width"},{default:a(e=>[S((d(),c(b,{link:"",type:"primary",icon:"Edit",onClick:_e=>G(e.row)},{default:a(()=>[_("\u4FEE\u6539")]),_:2},1032,["onClick"])),[[B,["app:device:edit"]]]),S((d(),c(b,{link:"",type:"primary",icon:"Delete",onClick:_e=>H(e.row)},{default:a(()=>[_("\u5220\u9664")]),_:2},1032,["onClick"])),[[B,["app:device:remove"]]])]),_:1})]),_:1},8,["data"])),[[be,t(Y)]]),S(l(me,{total:t(P),page:t(n).pageNum,"onUpdate:page":o[8]||(o[8]=e=>t(n).pageNum=e),limit:t(n).pageSize,"onUpdate:limit":o[9]||(o[9]=e=>t(n).pageSize=e),onPagination:C},null,8,["total","page","limit"]),[[Z,t(P)>0]]),l(fe,{title:t(E),modelValue:t(V),"onUpdate:modelValue":o[20]||(o[20]=e=>ee(V)?V.value=e:null),width:"500px","append-to-body":""},{footer:a(()=>[z("div",Te,[l(b,{type:"primary",onClick:re},{default:a(()=>[_("\u786E \u5B9A")]),_:1}),l(b,{onClick:ue},{default:a(()=>[_("\u53D6 \u6D88")]),_:1})])]),default:a(()=>[l(J,{ref:"deviceRef",model:t(u),rules:t(oe),"label-width":"80px"},{default:a(()=>[l(r,{label:"\u4EA7\u54C1\u578B\u53F7",prop:"supplierId"},{default:a(()=>[l(g,{modelValue:t(u).productId,"onUpdate:modelValue":o[10]||(o[10]=e=>t(u).productId=e),placeholder:"\u8BF7\u8F93\u5165\u4EA7\u54C1\u578B\u53F7"},{default:a(()=>[(d(!0),y(I,null,w(t(T),e=>(d(),c(s,{key:e.productId,label:e.productName,value:e.productId,disabled:e.status==1},null,8,["label","value","disabled"]))),128))]),_:1},8,["modelValue"])]),_:1}),l(r,{label:"\u4F9B\u5E94\u5546",prop:"supplierId"},{default:a(()=>[l(g,{modelValue:t(u).supplierId,"onUpdate:modelValue":o[11]||(o[11]=e=>t(u).supplierId=e),placeholder:"\u8BF7\u9009\u62E9"},{default:a(()=>[(d(!0),y(I,null,w(t(U),e=>(d(),c(s,{key:e.supplierId,label:e.supplierName,value:e.supplierId,disabled:e.status==1},null,8,["label","value","disabled"]))),128))]),_:1},8,["modelValue"])]),_:1}),l(r,{label:"\u8BBE\u5907\u6388\u6743",prop:"deviceStatus"},{default:a(()=>[l(g,{modelValue:t(u).deviceStatus,"onUpdate:modelValue":o[12]||(o[12]=e=>t(u).deviceStatus=e),placeholder:"\u8BF7\u9009\u62E9\u8BBE\u5907\u72B6\u6001"},{default:a(()=>[(d(!0),y(I,null,w(t(K),e=>(d(),c(s,{key:e.value,label:e.label,value:e.value},null,8,["label","value"]))),128))]),_:1},8,["modelValue"])]),_:1}),l(r,{label:"\u8BBE\u5907\u7F16\u53F7",prop:"deviceCode"},{default:a(()=>[l(h,{modelValue:t(u).deviceCode,"onUpdate:modelValue":o[13]||(o[13]=e=>t(u).deviceCode=e),placeholder:"\u8BF7\u8F93\u5165\u8BBE\u5907\u7F16\u53F7"},null,8,["modelValue"])]),_:1}),l(r,{label:"\u5165\u5E93\u4EBA",prop:"deviceInStockBy"},{default:a(()=>[l(h,{modelValue:t(u).deviceInStockBy,"onUpdate:modelValue":o[14]||(o[14]=e=>t(u).deviceInStockBy=e),placeholder:"\u8BF7\u8F93\u5165\u5165\u5E93\u4EBA"},null,8,["modelValue"])]),_:1}),l(r,{label:"\u5165\u5E93\u65F6\u95F4",prop:"deviceInStockTime"},{default:a(()=>[l(W,{clearable:"",modelValue:t(u).deviceInStockTime,"onUpdate:modelValue":o[15]||(o[15]=e=>t(u).deviceInStockTime=e),type:"date","value-format":"YYYY-MM-DD",placeholder:"\u8BF7\u9009\u62E9\u5165\u5E93\u65F6\u95F4"},null,8,["modelValue"])]),_:1}),l(r,{label:"\u51FA\u5E93\u4EBA",prop:"deviceOutStockBy"},{default:a(()=>[l(h,{modelValue:t(u).deviceOutStockBy,"onUpdate:modelValue":o[16]||(o[16]=e=>t(u).deviceOutStockBy=e),placeholder:"\u8BF7\u8F93\u5165\u51FA\u5E93\u4EBA"},null,8,["modelValue"])]),_:1}),l(r,{label:"\u51FA\u5E93\u65F6\u95F4",prop:"deviceOutStockTime"},{default:a(()=>[l(W,{clearable:"",modelValue:t(u).deviceOutStockTime,"onUpdate:modelValue":o[17]||(o[17]=e=>t(u).deviceOutStockTime=e),type:"date","value-format":"YYYY-MM-DD",placeholder:"\u8BF7\u9009\u62E9\u51FA\u5E93\u65F6\u95F4"},null,8,["modelValue"])]),_:1}),l(r,{label:"\u72B6\u6001",prop:"stockStatus"},{default:a(()=>[l(g,{modelValue:t(u).stockStatus,"onUpdate:modelValue":o[18]||(o[18]=e=>t(u).stockStatus=e),placeholder:"\u8BF7\u9009\u62E9\u72B6\u6001"},{default:a(()=>[(d(!0),y(I,null,w(t(R),e=>(d(),c(s,{key:e.value,label:e.label,value:e.value},null,8,["label","value"]))),128))]),_:1},8,["modelValue"])]),_:1}),l(r,{label:"\u5907\u6CE8",prop:"remark"},{default:a(()=>[l(h,{modelValue:t(u).remark,"onUpdate:modelValue":o[19]||(o[19]=e=>t(u).remark=e),type:"textarea",placeholder:"\u8BF7\u8F93\u5165\u5185\u5BB9"},null,8,["modelValue"])]),_:1})]),_:1},8,["model","rules"])]),_:1},8,["title","modelValue"])])}}});export{Oe as default};
