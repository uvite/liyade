import{H as I,z as me,u as ce,r as m,A as fe,B as be,d as p,C as T,o as k,c as ve,D as j,F as q,f as a,e,w as o,i as w,m as c,G as M,j as E,k as Ve,x as z,s as _e}from"./index.89a73f00.js";import"./lodash.3e03c529.js";function ge(f){return I({url:"/app/license/list",method:"get",params:f})}function he(f){return I({url:"/app/license/"+f,method:"get"})}function ye(f){return I({url:"/app/license",method:"post",data:f})}function we(f){return I({url:"/app/license",method:"put",data:f})}const je={class:"app-container"},Se={class:"dialog-footer"},Ue=me({name:"Licenses"}),De=Object.assign(Ue,{setup(f){const F=ce(),{proxy:_}=_e(),L=m([]),g=m([]),h=m(!1),D=m(!0),S=m(!0),Q=m([]),N=m([]),O=m(!0),G=m(!0),x=m(0),H=m(""),U=m(!1),J=fe({form:{},queryParams:{pageNum:1,pageSize:10,licenseId:null,deviceId:null,fileName:null,limitStart:null,limitEnd:null,projectName:null,projectSn:null,projectUsername:null,projectMobile:null},rules:{}}),{queryParams:u,form:n,rules:R}=be(J);function y(){D.value=!0,ge(u.value).then(d=>{L.value=d.rows,x.value=d.total,D.value=!1})}function W(){h.value=!1,X()}function X(){n.value={id:null,licenseId:null,fileName:null,limitStart:null,limitEnd:null,createBy:null,createTime:null,updateBy:null,updateTime:null,remark:null,projectName:null,projectUsername:null,projectMobile:null},g.value=[],_.resetForm("licensesRef")}function b(){u.value.pageNum=1,y()}function Z(){_.resetForm("queryRef"),b()}function ee(d){Q.value=d.map(l=>l.id),O.value=d.length!=1,G.value=!d.length}function le(d){const l=d.id;F.push("/license/detail?licenseId="+l)}function te(d){he(d.id).then(l=>{n.value=l.data,U.value=!0})}function ae(){_.$refs.licensesRef.validate(d=>{d&&(n.value.appDevicesStatusList=g.value,n.value.id!=null?we(n.value).then(l=>{_.$modal.msgSuccess("\u4FEE\u6539\u6210\u529F"),h.value=!1,y()}):ye(n.value).then(l=>{_.$modal.msgSuccess("\u65B0\u589E\u6210\u529F"),h.value=!1,y()}))})}function oe({row:d,rowIndex:l}){d.index=l+1}function ne(){let d={};d.deviceId="",d.used="",d.enabled="",g.value.push(d)}function de(){if(N.value.length==0)_.$modal.msgError("\u8BF7\u5148\u9009\u62E9\u8981\u5220\u9664\u7684\u6388\u6743\u7BA1\u7406\u6570\u636E");else{const d=g.value,l=N.value;g.value=d.filter(function(i){return l.indexOf(i.index)==-1})}}function ue(d){N.value=d.map(l=>l.index)}return y(),(d,l)=>{const i=p("el-input"),r=p("el-form-item"),v=p("el-button"),C=p("el-form"),K=p("el-col"),ie=p("right-toolbar"),A=p("el-row"),s=p("el-table-column"),Y=p("el-table"),re=p("pagination"),B=p("el-date-picker"),pe=p("el-divider"),P=p("el-dialog"),$=T("hasPermi"),se=T("loading");return k(),ve("div",je,[j(e(C,{model:a(u),ref:"queryRef",inline:!0,"label-width":"68px"},{default:o(()=>[e(r,{label:"license",prop:"licenseId"},{default:o(()=>[e(i,{modelValue:a(u).licenseId,"onUpdate:modelValue":l[0]||(l[0]=t=>a(u).licenseId=t),placeholder:"\u8BF7\u8F93\u5165license",clearable:"",onKeyup:w(b,["enter"])},null,8,["modelValue","onKeyup"])]),_:1}),e(r,{label:"\u8BBE\u5907Id",prop:"deviceId"},{default:o(()=>[e(i,{modelValue:a(u).deviceId,"onUpdate:modelValue":l[1]||(l[1]=t=>a(u).deviceId=t),placeholder:"\u8BF7\u8F93\u5165\u8BBE\u5907Id",clearable:"",onKeyup:w(b,["enter"])},null,8,["modelValue","onKeyup"])]),_:1}),e(r,{label:"\u9879\u76EE\u540D\u79F0",prop:"projectName"},{default:o(()=>[e(i,{modelValue:a(u).projectName,"onUpdate:modelValue":l[2]||(l[2]=t=>a(u).projectName=t),placeholder:"\u8BF7\u8F93\u5165\u9879\u76EE\u540D\u79F0",clearable:"",onKeyup:w(b,["enter"])},null,8,["modelValue","onKeyup"])]),_:1}),e(r,{label:"\u9879\u76EE\u7F16\u53F7",prop:"projectName"},{default:o(()=>[e(i,{modelValue:a(u).projectSn,"onUpdate:modelValue":l[3]||(l[3]=t=>a(u).projectSn=t),placeholder:"\u8BF7\u8F93\u5165\u9879\u76EE\u7F16\u53F7",clearable:"",onKeyup:w(b,["enter"])},null,8,["modelValue","onKeyup"])]),_:1}),e(r,{label:"\u8054\u7CFB\u4EBA",prop:"projectUsername"},{default:o(()=>[e(i,{modelValue:a(u).projectUsername,"onUpdate:modelValue":l[4]||(l[4]=t=>a(u).projectUsername=t),placeholder:"\u8BF7\u8F93\u5165\u8054\u7CFB\u4EBA\u59D3\u540D",clearable:"",onKeyup:w(b,["enter"])},null,8,["modelValue","onKeyup"])]),_:1}),e(r,{label:"\u7535\u8BDD",prop:"projectMobile"},{default:o(()=>[e(i,{modelValue:a(u).projectMobile,"onUpdate:modelValue":l[5]||(l[5]=t=>a(u).projectMobile=t),placeholder:"\u8BF7\u8F93\u5165\u8054\u7CFB\u4EBA\u7535\u8BDD",clearable:"",onKeyup:w(b,["enter"])},null,8,["modelValue","onKeyup"])]),_:1}),e(r,null,{default:o(()=>[e(v,{type:"primary",icon:"Search",onClick:b},{default:o(()=>[c("\u641C\u7D22")]),_:1}),e(v,{icon:"Refresh",onClick:Z},{default:o(()=>[c("\u91CD\u7F6E")]),_:1})]),_:1})]),_:1},8,["model"]),[[q,a(S)]]),e(A,{gutter:10,class:"mb8"},{default:o(()=>[e(K,{span:3}),e(ie,{showSearch:a(S),"onUpdate:showSearch":l[6]||(l[6]=t=>M(S)?S.value=t:null),onQueryTable:y},null,8,["showSearch"])]),_:1}),j((k(),E(Y,{data:a(L),onSelectionChange:ee},{default:o(()=>[e(s,{label:"license",align:"center",prop:"licenseId"}),e(s,{label:"\u9879\u76EE\u540D\u79F0",align:"center",width:"150",prop:"projectName"}),e(s,{label:"\u9879\u76EE\u7F16\u53F7",align:"center",width:"150",prop:"projectSn"}),e(s,{label:"\u8054\u7CFB\u4EBA\u59D3\u540D",align:"center",width:"100",prop:"projectUsername"}),e(s,{label:"\u8054\u7CFB\u4EBA\u7535\u8BDD",align:"center",width:"110",prop:"projectMobile"}),e(s,{label:"\u7533\u8BF7\u65F6\u95F4",align:"center",width:"160",prop:"createTime"}),e(s,{label:"\u64CD\u4F5C",align:"center","class-name":"small-padding fixed-width"},{default:o(t=>[j((k(),E(v,{link:"",type:"primary",icon:"Edit",onClick:V=>le(t.row)},{default:o(()=>[c("\u8BBE\u5907\u660E\u7EC6 ")]),_:2},1032,["onClick"])),[[$,["app:status:list"]]]),j((k(),E(v,{link:"",type:"primary",icon:"Edit",onClick:V=>te(t.row)},{default:o(()=>[c("\u6388\u6743\u660E\u7EC6 ")]),_:2},1032,["onClick"])),[[$,["app:licenses:list"]]])]),_:1})]),_:1},8,["data"])),[[se,a(D)]]),j(e(re,{total:a(x),page:a(u).pageNum,"onUpdate:page":l[7]||(l[7]=t=>a(u).pageNum=t),limit:a(u).pageSize,"onUpdate:limit":l[8]||(l[8]=t=>a(u).pageSize=t),onPagination:y},null,8,["total","page","limit"]),[[q,a(x)>0]]),e(P,{title:a(H),modelValue:a(h),"onUpdate:modelValue":l[17]||(l[17]=t=>M(h)?h.value=t:null),width:"500px","append-to-body":""},{footer:o(()=>[Ve("div",Se,[e(v,{type:"primary",onClick:ae},{default:o(()=>[c("\u786E \u5B9A")]),_:1}),e(v,{onClick:W},{default:o(()=>[c("\u53D6 \u6D88")]),_:1})])]),default:o(()=>[e(C,{ref:"licensesRef",model:a(n),rules:a(R),"label-width":"80px"},{default:o(()=>[e(r,{label:"license",prop:"licenseId"},{default:o(()=>[e(i,{modelValue:a(n).licenseId,"onUpdate:modelValue":l[9]||(l[9]=t=>a(n).licenseId=t),placeholder:"\u8BF7\u8F93\u5165license"},null,8,["modelValue"])]),_:1}),e(r,{label:"\u4E0B\u8F7D\u6587\u4EF6\u540D\u79F0",prop:"fileName"},{default:o(()=>[e(i,{modelValue:a(n).fileName,"onUpdate:modelValue":l[10]||(l[10]=t=>a(n).fileName=t),placeholder:"\u8BF7\u8F93\u5165\u4E0B\u8F7D\u6587\u4EF6\u540D\u79F0"},null,8,["modelValue"])]),_:1}),e(r,{label:"\u66F4\u65B0\u65F6\u95F4",prop:"limitStart"},{default:o(()=>[e(B,{clearable:"",modelValue:a(n).limitStart,"onUpdate:modelValue":l[11]||(l[11]=t=>a(n).limitStart=t),type:"date","value-format":"YYYY-MM-DD",placeholder:"\u8BF7\u9009\u62E9\u66F4\u65B0\u65F6\u95F4"},null,8,["modelValue"])]),_:1}),e(r,{label:"\u66F4\u65B0\u65F6\u95F4",prop:"limitEnd"},{default:o(()=>[e(B,{clearable:"",modelValue:a(n).limitEnd,"onUpdate:modelValue":l[12]||(l[12]=t=>a(n).limitEnd=t),type:"date","value-format":"YYYY-MM-DD",placeholder:"\u8BF7\u9009\u62E9\u66F4\u65B0\u65F6\u95F4"},null,8,["modelValue"])]),_:1}),e(r,{label:"\u5907\u6CE8",prop:"remark"},{default:o(()=>[e(i,{modelValue:a(n).remark,"onUpdate:modelValue":l[13]||(l[13]=t=>a(n).remark=t),type:"textarea",placeholder:"\u8BF7\u8F93\u5165\u5185\u5BB9"},null,8,["modelValue"])]),_:1}),e(r,{label:"\u9879\u76EE\u540D\u79F0",prop:"projectName"},{default:o(()=>[e(i,{modelValue:a(n).projectName,"onUpdate:modelValue":l[14]||(l[14]=t=>a(n).projectName=t),placeholder:"\u8BF7\u8F93\u5165\u9879\u76EE\u540D\u79F0"},null,8,["modelValue"])]),_:1}),e(r,{label:"\u8054\u7CFB\u4EBA\u59D3\u540D",prop:"projectUsername"},{default:o(()=>[e(i,{modelValue:a(n).projectUsername,"onUpdate:modelValue":l[15]||(l[15]=t=>a(n).projectUsername=t),placeholder:"\u8BF7\u8F93\u5165\u8054\u7CFB\u4EBA\u59D3\u540D"},null,8,["modelValue"])]),_:1}),e(r,{label:"\u8054\u7CFB\u4EBA\u7535\u8BDD",prop:"projectMobile"},{default:o(()=>[e(i,{modelValue:a(n).projectMobile,"onUpdate:modelValue":l[16]||(l[16]=t=>a(n).projectMobile=t),placeholder:"\u8BF7\u8F93\u5165\u8054\u7CFB\u4EBA\u7535\u8BDD"},null,8,["modelValue"])]),_:1}),e(pe,{"content-position":"center"},{default:o(()=>[c("\u6388\u6743\u7BA1\u7406\u4FE1\u606F")]),_:1}),e(A,{gutter:10,class:"mb8"},{default:o(()=>[e(K,{span:1.5},{default:o(()=>[e(v,{type:"primary",icon:"Plus",onClick:ne},{default:o(()=>[c("\u6DFB\u52A0")]),_:1})]),_:1},8,["span"]),e(K,{span:1.5},{default:o(()=>[e(v,{type:"danger",icon:"Delete",onClick:de},{default:o(()=>[c("\u5220\u9664")]),_:1})]),_:1},8,["span"])]),_:1}),e(Y,{data:a(g),"row-class-name":oe,onSelectionChange:ue,ref:"appDevicesStatus"},{default:o(()=>[e(s,{type:"selection",width:"50",align:"center"}),e(s,{label:"\u5E8F\u53F7",align:"center",prop:"index",width:"50"}),e(s,{label:"\u8BBE\u5907id",prop:"deviceId",width:"150"},{default:o(t=>[e(i,{modelValue:t.row.deviceId,"onUpdate:modelValue":V=>t.row.deviceId=V,placeholder:"\u8BF7\u8F93\u5165\u8BBE\u5907id"},null,8,["modelValue","onUpdate:modelValue"])]),_:1}),e(s,{label:"\u662F\u5426\u4F7F\u7528",prop:"used",width:"150"},{default:o(t=>[e(i,{modelValue:t.row.used,"onUpdate:modelValue":V=>t.row.used=V,placeholder:"\u8BF7\u8F93\u5165\u662F\u5426\u4F7F\u7528"},null,8,["modelValue","onUpdate:modelValue"])]),_:1}),e(s,{label:"\u72B6\u6001",prop:"enabled",width:"150"},{default:o(t=>[e(i,{modelValue:t.row.enabled,"onUpdate:modelValue":V=>t.row.enabled=V,placeholder:"\u8BF7\u8F93\u5165\u72B6\u6001"},null,8,["modelValue","onUpdate:modelValue"])]),_:1})]),_:1},8,["data"])]),_:1},8,["model","rules"])]),_:1},8,["title","modelValue"]),e(P,{title:"\u6388\u6743\u4FE1\u606F",modelValue:a(U),"onUpdate:modelValue":l[18]||(l[18]=t=>M(U)?U.value=t:null),width:"400px","append-to-body":""},{default:o(()=>[e(C,{model:a(n),rules:a(R),"label-width":"130px"},{default:o(()=>[e(r,{label:"\u5BC6\u7801\uFF1A"},{default:o(()=>[c(z(a(n).password),1)]),_:1}),e(r,{label:"\u5230\u671F\u65E5\u671F\uFF1A"},{default:o(()=>[c(z(a(n).limitEnd),1)]),_:1})]),_:1},8,["model","rules"])]),_:1},8,["modelValue"])])}}});export{De as default};