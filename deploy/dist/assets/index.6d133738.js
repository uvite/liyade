import{A as U,K as _e,z as be,r as s,B as ke,C as ye,d as i,D as A,o as r,c as I,F as g,G,f as t,e as l,w as o,M as B,N as D,j as v,i as $,m as _,H,x as Se,k as ge,s as Ve}from"./index.41696075.js";function Ie(m){return U({url:"/app/device/list",method:"get",params:m})}function J(m){return U({url:"/app/device/"+_e(m),method:"get"})}function he(m){return U({url:"/app/device",method:"post",data:m})}function we(m){return U({url:"/app/device",method:"put",data:m})}function Be(m){return U({url:"/app/device/"+m,method:"delete"})}const De={class:"app-container"},Ue={class:"dialog-footer"},Te=be({name:"Device"}),Oe=Object.assign(Te,{setup(m){const{proxy:f}=Ve(),{device_status:W,stock_status:F,product_type:X}=f.useDict("device_status","stock_status","product_type"),O=s([]),x=s([]),M=s([]),y=s(!1),N=s(!0),T=s(!0),K=s([]),Z=s(!0),P=s(!0),R=s(0),q=s(""),ee=ke({form:{},queryParams:{pageNum:1,pageSize:10,productId:null,supplierId:null,deviceStatus:null,deviceId:null,deviceInStockBy:null,deviceInStockTime:null,deviceOutStockBy:null,deviceOutStockTime:null,stockStatus:null},rules:{}}),{queryParams:u,form:n,rules:le}=ye(ee);function S(){N.value=!0,Ie(u.value).then(d=>{M.value=d.rows,R.value=d.total,N.value=!1}),J().then(d=>{x.value=d.suppliers,O.value=d.products})}function te(){y.value=!1,z()}function z(){n.value={id:null,productId:null,supplierId:null,deviceStatus:null,deviceId:null,createBy:null,createTime:null,updateBy:null,updateTime:null,remark:null,deviceInStockBy:null,deviceInStockTime:null,deviceOutStockBy:null,deviceOutStockTime:null,stockStatus:null,deleteBy:null,deleteTime:null,isDeleted:null},f.resetForm("deviceRef")}function h(){u.value.pageNum=1,S()}function ae(){f.resetForm("queryRef"),h()}function oe(d){K.value=d.map(a=>a.id),Z.value=d.length!=1,P.value=!d.length}function ue(d){z();const a=d.id||K.value;J(a).then(c=>{x.value=c.suppliers,O.value=c.products,n.value=c.data,n.value.productId=parseInt(c.data.productId),n.value.supplierId=parseInt(c.data.supplierId),y.value=!0,q.value="\u4FEE\u6539\u8BBE\u5907\u7BA1\u7406"})}function ne(){f.$refs.deviceRef.validate(d=>{d&&(n.value.id!=null?we(n.value).then(a=>{f.$modal.msgSuccess("\u4FEE\u6539\u6210\u529F"),y.value=!1,S()}):he(n.value).then(a=>{f.$modal.msgSuccess("\u65B0\u589E\u6210\u529F"),y.value=!1,S()}))})}function E(d){const a=d.id||K.value;f.$modal.confirm('\u662F\u5426\u786E\u8BA4\u5220\u9664\u8BBE\u5907\u7BA1\u7406\u7F16\u53F7\u4E3A"'+a+'"\u7684\u6570\u636E\u9879\uFF1F').then(function(){return Be(a)}).then(()=>{S(),f.$modal.msgSuccess("\u5220\u9664\u6210\u529F")}).catch(()=>{})}function de(){f.download("app/device/export",{...u.value},`device_${new Date().getTime()}.xlsx`)}return S(),(d,a)=>{const c=i("el-option"),w=i("el-select"),p=i("el-form-item"),V=i("el-input"),b=i("el-button"),L=i("el-form"),Q=i("el-col"),ie=i("right-toolbar"),re=i("el-row"),k=i("el-table-column"),pe=i("dict-tag"),ce=i("el-switch"),se=i("el-table"),me=i("pagination"),j=i("el-date-picker"),ve=i("el-dialog"),C=A("hasPermi"),fe=A("loading");return r(),I("div",De,[g(l(L,{model:t(u),ref:"queryRef",inline:!0,"label-width":"68px"},{default:o(()=>[l(p,{label:"\u4EA7\u54C1\u540D\u79F0",prop:"productId"},{default:o(()=>[l(w,{modelValue:t(u).productId,"onUpdate:modelValue":a[0]||(a[0]=e=>t(u).productId=e),placeholder:"\u8BF7\u8F93\u5165\u4EA7\u54C1\u578B\u53F7"},{default:o(()=>[(r(!0),I(B,null,D(t(O),e=>(r(),v(c,{key:e.productId,label:e.productName,value:e.productId,disabled:e.status==1},null,8,["label","value","disabled"]))),128))]),_:1},8,["modelValue"])]),_:1}),l(p,{label:"\u4F9B\u5E94\u5546",prop:"supplierId"},{default:o(()=>[l(w,{modelValue:t(u).supplierId,"onUpdate:modelValue":a[1]||(a[1]=e=>t(u).supplierId=e),placeholder:"\u8BF7\u9009\u62E9"},{default:o(()=>[(r(!0),I(B,null,D(t(x),e=>(r(),v(c,{key:e.supplierId,label:e.supplierName,value:e.supplierId,disabled:e.status==1},null,8,["label","value","disabled"]))),128))]),_:1},8,["modelValue"])]),_:1}),l(p,{label:"\u8BBE\u5907\u72B6\u6001",prop:"deviceStatus"},{default:o(()=>[l(w,{modelValue:t(u).deviceStatus,"onUpdate:modelValue":a[2]||(a[2]=e=>t(u).deviceStatus=e),placeholder:"\u8BF7\u9009\u62E9\u8BBE\u5907\u72B6\u6001",clearable:""},{default:o(()=>[(r(!0),I(B,null,D(t(W),e=>(r(),v(c,{key:e.value,label:e.label,value:e.value},null,8,["label","value"]))),128))]),_:1},8,["modelValue"])]),_:1}),l(p,{label:"\u7F16\u53F7",prop:"deviceId"},{default:o(()=>[l(V,{modelValue:t(u).deviceId,"onUpdate:modelValue":a[3]||(a[3]=e=>t(u).deviceId=e),placeholder:"\u8BF7\u8F93\u5165\u7F16\u53F7",clearable:"",onKeyup:$(h,["enter"])},null,8,["modelValue","onKeyup"])]),_:1}),l(p,{label:"\u5165\u5E93\u4EBA",prop:"deviceInStockBy"},{default:o(()=>[l(V,{modelValue:t(u).deviceInStockBy,"onUpdate:modelValue":a[4]||(a[4]=e=>t(u).deviceInStockBy=e),placeholder:"\u8BF7\u8F93\u5165\u5165\u5E93\u4EBA",clearable:"",onKeyup:$(h,["enter"])},null,8,["modelValue","onKeyup"])]),_:1}),l(p,{label:"\u51FA\u5E93\u4EBA",prop:"deviceOutStockBy"},{default:o(()=>[l(V,{modelValue:t(u).deviceOutStockBy,"onUpdate:modelValue":a[5]||(a[5]=e=>t(u).deviceOutStockBy=e),placeholder:"\u8BF7\u8F93\u5165\u51FA\u5E93\u4EBA",clearable:"",onKeyup:$(h,["enter"])},null,8,["modelValue","onKeyup"])]),_:1}),l(p,{label:"\u72B6\u6001",prop:"stockStatus"},{default:o(()=>[l(w,{modelValue:t(u).stockStatus,"onUpdate:modelValue":a[6]||(a[6]=e=>t(u).stockStatus=e),placeholder:"\u8BF7\u9009\u62E9\u72B6\u6001",clearable:""},{default:o(()=>[(r(!0),I(B,null,D(t(F),e=>(r(),v(c,{key:e.value,label:e.label,value:e.value},null,8,["label","value"]))),128))]),_:1},8,["modelValue"])]),_:1}),l(p,null,{default:o(()=>[l(b,{type:"primary",icon:"Search",onClick:h},{default:o(()=>[_("\u641C\u7D22")]),_:1}),l(b,{icon:"Refresh",onClick:ae},{default:o(()=>[_("\u91CD\u7F6E")]),_:1})]),_:1})]),_:1},8,["model"]),[[G,t(T)]]),l(re,{gutter:10,class:"mb8"},{default:o(()=>[l(Q,{span:1.5},{default:o(()=>[g((r(),v(b,{type:"danger",plain:"",icon:"Delete",disabled:t(P),onClick:E},{default:o(()=>[_("\u5220\u9664")]),_:1},8,["disabled"])),[[C,["app:device:remove"]]])]),_:1},8,["span"]),l(Q,{span:1.5},{default:o(()=>[g((r(),v(b,{type:"warning",plain:"",icon:"Download",onClick:de},{default:o(()=>[_("\u5BFC\u51FA")]),_:1})),[[C,["app:device:export"]]])]),_:1},8,["span"]),l(ie,{showSearch:t(T),"onUpdate:showSearch":a[7]||(a[7]=e=>H(T)?T.value=e:null),onQueryTable:S},null,8,["showSearch"])]),_:1}),g((r(),v(se,{data:t(M),onSelectionChange:oe},{default:o(()=>[l(k,{type:"selection",width:"55",align:"center"}),l(k,{label:"\u8BBE\u5907\u7F16\u53F7",align:"center",prop:"deviceId"}),l(k,{label:"\u4EA7\u54C1\u7C7B\u578B",align:"center"},{default:o(e=>[l(pe,{options:t(X),value:e.row.product.productType},null,8,["options","value"])]),_:1}),l(k,{label:"\u4F9B\u5E94\u5546",align:"center"},{default:o(e=>[_(Se(e.row.supplier.supplierShortName),1)]),_:1}),l(k,{label:"\u8BBE\u5907\u6388\u6743",align:"center"},{default:o(e=>[l(ce,{modelValue:e.row.used,"onUpdate:modelValue":Y=>e.row.used=Y,"active-value":"1","inactive-value":"0",disabled:"true"},null,8,["modelValue","onUpdate:modelValue"])]),_:1}),l(k,{label:"\u521B\u5EFA\u4EBA",align:"center",prop:"createBy"}),l(k,{label:"\u521B\u5EFA\u65F6\u95F4",align:"center",prop:"createTime"}),l(k,{label:"\u64CD\u4F5C",align:"center","class-name":"small-padding fixed-width"},{default:o(e=>[g((r(),v(b,{link:"",type:"primary",icon:"Edit",onClick:Y=>ue(e.row)},{default:o(()=>[_("\u51FA\u5165\u5E93\u660E\u7EC6")]),_:2},1032,["onClick"])),[[C,["app:device:edit"]]]),g((r(),v(b,{link:"",type:"primary",icon:"Delete",onClick:Y=>E(e.row)},{default:o(()=>[_("\u5220\u9664")]),_:2},1032,["onClick"])),[[C,["app:device:remove"]]])]),_:1})]),_:1},8,["data"])),[[fe,t(N)]]),g(l(me,{total:t(R),page:t(u).pageNum,"onUpdate:page":a[8]||(a[8]=e=>t(u).pageNum=e),limit:t(u).pageSize,"onUpdate:limit":a[9]||(a[9]=e=>t(u).pageSize=e),onPagination:S},null,8,["total","page","limit"]),[[G,t(R)>0]]),l(ve,{title:t(q),modelValue:t(y),"onUpdate:modelValue":a[16]||(a[16]=e=>H(y)?y.value=e:null),width:"500px","append-to-body":""},{footer:o(()=>[ge("div",Ue,[l(b,{type:"primary",onClick:ne},{default:o(()=>[_("\u786E \u5B9A")]),_:1}),l(b,{onClick:te},{default:o(()=>[_("\u53D6 \u6D88")]),_:1})])]),default:o(()=>[l(L,{ref:"deviceRef",model:t(n),rules:t(le),"label-width":"80px"},{default:o(()=>[l(p,{label:"\u8BBE\u5907\u7F16\u53F7",prop:"deviceId"},{default:o(()=>[l(V,{modelValue:t(n).deviceId,"onUpdate:modelValue":a[10]||(a[10]=e=>t(n).deviceId=e),placeholder:"\u8BF7\u8F93\u5165\u8BBE\u5907\u7F16\u53F7"},null,8,["modelValue"])]),_:1}),l(p,{label:"\u5165\u5E93\u4EBA",prop:"deviceInStockBy"},{default:o(()=>[l(V,{modelValue:t(n).deviceInStockBy,"onUpdate:modelValue":a[11]||(a[11]=e=>t(n).deviceInStockBy=e),placeholder:"\u8BF7\u8F93\u5165\u5165\u5E93\u4EBA"},null,8,["modelValue"])]),_:1}),l(p,{label:"\u5165\u5E93\u65F6\u95F4",prop:"deviceInStockTime"},{default:o(()=>[l(j,{clearable:"",modelValue:t(n).deviceInStockTime,"onUpdate:modelValue":a[12]||(a[12]=e=>t(n).deviceInStockTime=e),type:"date","value-format":"YYYY-MM-DD",placeholder:"\u8BF7\u9009\u62E9\u5165\u5E93\u65F6\u95F4"},null,8,["modelValue"])]),_:1}),l(p,{label:"\u51FA\u5E93\u4EBA",prop:"deviceOutStockBy"},{default:o(()=>[l(V,{modelValue:t(n).deviceOutStockBy,"onUpdate:modelValue":a[13]||(a[13]=e=>t(n).deviceOutStockBy=e),placeholder:"\u8BF7\u8F93\u5165\u51FA\u5E93\u4EBA"},null,8,["modelValue"])]),_:1}),l(p,{label:"\u51FA\u5E93\u65F6\u95F4",prop:"deviceOutStockTime"},{default:o(()=>[l(j,{clearable:"",modelValue:t(n).deviceOutStockTime,"onUpdate:modelValue":a[14]||(a[14]=e=>t(n).deviceOutStockTime=e),type:"date","value-format":"YYYY-MM-DD",placeholder:"\u8BF7\u9009\u62E9\u51FA\u5E93\u65F6\u95F4"},null,8,["modelValue"])]),_:1}),l(p,{label:"\u72B6\u6001",prop:"stockStatus"},{default:o(()=>[l(w,{modelValue:t(n).stockStatus,"onUpdate:modelValue":a[15]||(a[15]=e=>t(n).stockStatus=e),placeholder:"\u8BF7\u9009\u62E9\u72B6\u6001"},{default:o(()=>[(r(!0),I(B,null,D(t(F),e=>(r(),v(c,{key:e.value,label:e.label,value:e.value},null,8,["label","value"]))),128))]),_:1},8,["modelValue"])]),_:1})]),_:1},8,["model","rules"])]),_:1},8,["title","modelValue"])])}}});export{Oe as default};