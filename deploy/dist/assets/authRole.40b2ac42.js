import{z as E,a as F,r as i,L as K,d as s,D as O,o as R,c as G,e as t,w as a,f as o,F as y,j as H,k as m,x as C,G as L,H as V,m as S,s as P}from"./index.b6666f9f.js";import{c as q,d as J}from"./user.a120fda6.js";const M={class:"app-container"},Q=m("h4",{class:"form-header h4"},"\u57FA\u672C\u4FE1\u606F",-1),W=m("h4",{class:"form-header h4"},"\u89D2\u8272\u4FE1\u606F",-1),X={style:{"text-align":"center","margin-left":"-120px","margin-top":"30px"}},Y=E({name:"AuthRole"}),oe=Object.assign(Y,{setup(Z){const b=F(),{proxy:f}=P(),g=i(!0),v=i(0),u=i(1),d=i(10),h=i([]),_=i([]),r=i({nickName:void 0,userName:void 0,userId:void 0});function $(l){f.$refs.roleRef.toggleRowSelection(l)}function T(l){h.value=l.map(e=>e.roleId)}function j(l){return l.roleId}function w(){const l={path:"/system/user"};f.$tab.closeOpenPage(l)}function B(){const l=r.value.userId,e=h.value.join(",");J({userId:l,roleIds:e}).then(c=>{f.$modal.msgSuccess("\u6388\u6743\u6210\u529F"),w()})}return(()=>{const l=b.params&&b.params.userId;l&&(g.value=!0,q(l).then(e=>{r.value=e.user,_.value=e.roles,v.value=_.value.length,K(()=>{_.value.forEach(c=>{c.flag&&f.$refs.roleRef.toggleRowSelection(c)})}),g.value=!1}))})(),(l,e)=>{const c=s("el-input"),k=s("el-form-item"),x=s("el-col"),D=s("el-row"),I=s("el-form"),p=s("el-table-column"),U=s("el-table"),A=s("pagination"),N=s("el-button"),z=O("loading");return R(),G("div",M,[Q,t(I,{model:o(r),"label-width":"80px"},{default:a(()=>[t(D,null,{default:a(()=>[t(x,{span:8,offset:2},{default:a(()=>[t(k,{label:"\u7528\u6237\u6635\u79F0",prop:"nickName"},{default:a(()=>[t(c,{modelValue:o(r).nickName,"onUpdate:modelValue":e[0]||(e[0]=n=>o(r).nickName=n),disabled:""},null,8,["modelValue"])]),_:1})]),_:1}),t(x,{span:8,offset:2},{default:a(()=>[t(k,{label:"\u767B\u5F55\u8D26\u53F7",prop:"userName"},{default:a(()=>[t(c,{modelValue:o(r).userName,"onUpdate:modelValue":e[1]||(e[1]=n=>o(r).userName=n),disabled:""},null,8,["modelValue"])]),_:1})]),_:1})]),_:1})]),_:1},8,["model"]),W,y((R(),H(U,{"row-key":j,onRowClick:$,ref:"roleRef",onSelectionChange:T,data:o(_).slice((o(u)-1)*o(d),o(u)*o(d))},{default:a(()=>[t(p,{label:"\u5E8F\u53F7",width:"55",type:"index",align:"center"},{default:a(n=>[m("span",null,C((o(u)-1)*o(d)+n.$index+1),1)]),_:1}),t(p,{type:"selection","reserve-selection":!0,width:"55"}),t(p,{label:"\u89D2\u8272\u7F16\u53F7",align:"center",prop:"roleId"}),t(p,{label:"\u89D2\u8272\u540D\u79F0",align:"center",prop:"roleName"}),t(p,{label:"\u6743\u9650\u5B57\u7B26",align:"center",prop:"roleKey"}),t(p,{label:"\u521B\u5EFA\u65F6\u95F4",align:"center",prop:"createTime",width:"180"},{default:a(n=>[m("span",null,C(l.parseTime(n.row.createTime)),1)]),_:1})]),_:1},8,["data"])),[[z,o(g)]]),y(t(A,{total:o(v),page:o(u),"onUpdate:page":e[2]||(e[2]=n=>V(u)?u.value=n:null),limit:o(d),"onUpdate:limit":e[3]||(e[3]=n=>V(d)?d.value=n:null)},null,8,["total","page","limit"]),[[L,o(v)>0]]),t(I,{"label-width":"100px"},{default:a(()=>[m("div",X,[t(N,{type:"primary",onClick:e[4]||(e[4]=n=>B())},{default:a(()=>[S("\u63D0\u4EA4")]),_:1}),t(N,{onClick:e[5]||(e[5]=n=>w())},{default:a(()=>[S("\u8FD4\u56DE")]),_:1})])]),_:1})])}}});export{oe as default};
