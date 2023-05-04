import{a as _}from"./user.b5658a0c.js";import{r as k,d as o,o as y,j as N,w as l,e,m as n,f as C,s as U}from"./index.2302387d.js";const q={__name:"userInfo",props:{user:{type:Object}},setup(t){const p=t,{proxy:m}=U(),g=k({nickName:[{required:!0,message:"\u7528\u6237\u6635\u79F0\u4E0D\u80FD\u4E3A\u7A7A",trigger:"blur"}],email:[{required:!0,message:"\u90AE\u7BB1\u5730\u5740\u4E0D\u80FD\u4E3A\u7A7A",trigger:"blur"},{type:"email",message:"\u8BF7\u8F93\u5165\u6B63\u786E\u7684\u90AE\u7BB1\u5730\u5740",trigger:["blur","change"]}],phonenumber:[{required:!0,message:"\u624B\u673A\u53F7\u7801\u4E0D\u80FD\u4E3A\u7A7A",trigger:"blur"},{pattern:/^1[3|4|5|6|7|8|9][0-9]\d{8}$/,message:"\u8BF7\u8F93\u5165\u6B63\u786E\u7684\u624B\u673A\u53F7\u7801",trigger:"blur"}]});function c(){m.$refs.userRef.validate(d=>{d&&_(p.user).then(r=>{m.$modal.msgSuccess("\u4FEE\u6539\u6210\u529F")})})}function b(){m.$tab.closePage()}return(d,r)=>{const s=o("el-input"),u=o("el-form-item"),i=o("el-radio"),V=o("el-radio-group"),f=o("el-button"),x=o("el-form");return y(),N(x,{ref:"userRef",model:t.user,rules:C(g),"label-width":"80px"},{default:l(()=>[e(u,{label:"\u7528\u6237\u6635\u79F0",prop:"nickName"},{default:l(()=>[e(s,{modelValue:t.user.nickName,"onUpdate:modelValue":r[0]||(r[0]=a=>t.user.nickName=a),maxlength:"30"},null,8,["modelValue"])]),_:1}),e(u,{label:"\u624B\u673A\u53F7\u7801",prop:"phonenumber"},{default:l(()=>[e(s,{modelValue:t.user.phonenumber,"onUpdate:modelValue":r[1]||(r[1]=a=>t.user.phonenumber=a),maxlength:"11"},null,8,["modelValue"])]),_:1}),e(u,{label:"\u90AE\u7BB1",prop:"email"},{default:l(()=>[e(s,{modelValue:t.user.email,"onUpdate:modelValue":r[2]||(r[2]=a=>t.user.email=a),maxlength:"50"},null,8,["modelValue"])]),_:1}),e(u,{label:"\u6027\u522B"},{default:l(()=>[e(V,{modelValue:t.user.sex,"onUpdate:modelValue":r[3]||(r[3]=a=>t.user.sex=a)},{default:l(()=>[e(i,{label:"0"},{default:l(()=>[n("\u7537")]),_:1}),e(i,{label:"1"},{default:l(()=>[n("\u5973")]),_:1})]),_:1},8,["modelValue"])]),_:1}),e(u,null,{default:l(()=>[e(f,{type:"primary",onClick:c},{default:l(()=>[n("\u4FDD\u5B58")]),_:1}),e(f,{type:"danger",onClick:b},{default:l(()=>[n("\u5173\u95ED")]),_:1})]),_:1})]),_:1},8,["model","rules"])}}};export{q as default};
