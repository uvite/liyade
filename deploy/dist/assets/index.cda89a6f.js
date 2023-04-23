import{z as pe,r as f,B as ie,C as ce,d as p,D as Y,o as c,c as k,F as h,G as j,f as t,e,w as l,i as H,M as Q,N as E,j as b,H as $,m as d,k as I,x as i,l as A,s as me}from"./index.b6666f9f.js";import{l as fe,d as _e,c as ge}from"./operlog.944435ea.js";const be={class:"app-container"},ve={key:0},ye={key:1},he={class:"dialog-footer"},we=pe({name:"Operlog"}),Te=Object.assign(we,{setup(Ve){const{proxy:_}=me(),{sys_oper_type:T,sys_common_status:q}=_.useDict("sys_oper_type","sys_common_status"),B=f([]),w=f(!1),S=f(!0),C=f(!0),P=f([]);f(!0);const K=f(!0),D=f(0);f("");const V=f([]),N=f({prop:"operTime",order:"descending"}),G=ie({form:{},queryParams:{pageNum:1,pageSize:10,title:void 0,operName:void 0,businessType:void 0,status:void 0}}),{queryParams:n,form:s}=ce(G);function v(){S.value=!0,fe(_.addDateRange(n.value,V.value)).then(r=>{B.value=r.rows,D.value=r.total,S.value=!1})}function J(r,a){return _.selectDictLabel(T.value,r.businessType)}function R(){n.value.pageNum=1,v()}function W(){V.value=[],_.resetForm("queryRef"),n.value.pageNum=1,_.$refs.operlogRef.sort(N.value.prop,N.value.order)}function X(r){P.value=r.map(a=>a.operId),K.value=!r.length}function Z(r,a,U){n.value.orderByColumn=r.prop,n.value.isAsc=r.order,v()}function ee(r){w.value=!0,s.value=r}function le(r){const a=r.operId||P.value;_.$modal.confirm('\u662F\u5426\u786E\u8BA4\u5220\u9664\u65E5\u5FD7\u7F16\u53F7\u4E3A"'+a+'"\u7684\u6570\u636E\u9879?').then(function(){return _e(a)}).then(()=>{v(),_.$modal.msgSuccess("\u5220\u9664\u6210\u529F")}).catch(()=>{})}function te(){_.$modal.confirm("\u662F\u5426\u786E\u8BA4\u6E05\u7A7A\u6240\u6709\u64CD\u4F5C\u65E5\u5FD7\u6570\u636E\u9879?").then(function(){return ge()}).then(()=>{v(),_.$modal.msgSuccess("\u6E05\u7A7A\u6210\u529F")}).catch(()=>{})}function oe(){_.download("monitor/operlog/export",{...n.value},`config_${new Date().getTime()}.xlsx`)}return v(),(r,a)=>{const U=p("el-input"),u=p("el-form-item"),L=p("el-option"),M=p("el-select"),ae=p("el-date-picker"),y=p("el-button"),z=p("el-form"),m=p("el-col"),ne=p("right-toolbar"),F=p("el-row"),g=p("el-table-column"),O=p("dict-tag"),se=p("el-table"),re=p("pagination"),ue=p("el-dialog"),x=Y("hasPermi"),de=Y("loading");return c(),k("div",be,[h(e(z,{model:t(n),ref:"queryRef",inline:!0,"label-width":"68px"},{default:l(()=>[e(u,{label:"\u7CFB\u7EDF\u6A21\u5757",prop:"title"},{default:l(()=>[e(U,{modelValue:t(n).title,"onUpdate:modelValue":a[0]||(a[0]=o=>t(n).title=o),placeholder:"\u8BF7\u8F93\u5165\u7CFB\u7EDF\u6A21\u5757",clearable:"",style:{width:"240px"},onKeyup:H(R,["enter"])},null,8,["modelValue","onKeyup"])]),_:1}),e(u,{label:"\u64CD\u4F5C\u4EBA\u5458",prop:"operName"},{default:l(()=>[e(U,{modelValue:t(n).operName,"onUpdate:modelValue":a[1]||(a[1]=o=>t(n).operName=o),placeholder:"\u8BF7\u8F93\u5165\u64CD\u4F5C\u4EBA\u5458",clearable:"",style:{width:"240px"},onKeyup:H(R,["enter"])},null,8,["modelValue","onKeyup"])]),_:1}),e(u,{label:"\u7C7B\u578B",prop:"businessType"},{default:l(()=>[e(M,{modelValue:t(n).businessType,"onUpdate:modelValue":a[2]||(a[2]=o=>t(n).businessType=o),placeholder:"\u64CD\u4F5C\u7C7B\u578B",clearable:"",style:{width:"240px"}},{default:l(()=>[(c(!0),k(Q,null,E(t(T),o=>(c(),b(L,{key:o.value,label:o.label,value:o.value},null,8,["label","value"]))),128))]),_:1},8,["modelValue"])]),_:1}),e(u,{label:"\u72B6\u6001",prop:"status"},{default:l(()=>[e(M,{modelValue:t(n).status,"onUpdate:modelValue":a[3]||(a[3]=o=>t(n).status=o),placeholder:"\u64CD\u4F5C\u72B6\u6001",clearable:"",style:{width:"240px"}},{default:l(()=>[(c(!0),k(Q,null,E(t(q),o=>(c(),b(L,{key:o.value,label:o.label,value:o.value},null,8,["label","value"]))),128))]),_:1},8,["modelValue"])]),_:1}),e(u,{label:"\u64CD\u4F5C\u65F6\u95F4",style:{width:"308px"}},{default:l(()=>[e(ae,{modelValue:t(V),"onUpdate:modelValue":a[4]||(a[4]=o=>$(V)?V.value=o:null),"value-format":"YYYY-MM-DD HH:mm:ss",type:"daterange","range-separator":"-","start-placeholder":"\u5F00\u59CB\u65E5\u671F","end-placeholder":"\u7ED3\u675F\u65E5\u671F","default-time":[new Date(2e3,1,1,0,0,0),new Date(2e3,1,1,23,59,59)]},null,8,["modelValue","default-time"])]),_:1}),e(u,null,{default:l(()=>[e(y,{type:"primary",icon:"Search",onClick:R},{default:l(()=>[d("\u641C\u7D22")]),_:1}),e(y,{icon:"Refresh",onClick:W},{default:l(()=>[d("\u91CD\u7F6E")]),_:1})]),_:1})]),_:1},8,["model"]),[[j,t(C)]]),e(F,{gutter:10,class:"mb8"},{default:l(()=>[e(m,{span:1.5},{default:l(()=>[h((c(),b(y,{type:"danger",plain:"",icon:"Delete",disabled:t(K),onClick:le},{default:l(()=>[d("\u5220\u9664")]),_:1},8,["disabled"])),[[x,["monitor:operlog:remove"]]])]),_:1},8,["span"]),e(m,{span:1.5},{default:l(()=>[h((c(),b(y,{type:"danger",plain:"",icon:"Delete",onClick:te},{default:l(()=>[d("\u6E05\u7A7A")]),_:1})),[[x,["monitor:operlog:remove"]]])]),_:1},8,["span"]),e(m,{span:1.5},{default:l(()=>[h((c(),b(y,{type:"warning",plain:"",icon:"Download",onClick:oe},{default:l(()=>[d("\u5BFC\u51FA")]),_:1})),[[x,["monitor:operlog:export"]]])]),_:1},8,["span"]),e(ne,{showSearch:t(C),"onUpdate:showSearch":a[5]||(a[5]=o=>$(C)?C.value=o:null),onQueryTable:v},null,8,["showSearch"])]),_:1}),h((c(),b(se,{ref:"operlogRef",data:t(B),onSelectionChange:X,"default-sort":t(N),onSortChange:Z},{default:l(()=>[e(g,{type:"selection",width:"50",align:"center"}),e(g,{label:"\u65E5\u5FD7\u7F16\u53F7",align:"center",prop:"operId"}),e(g,{label:"\u7CFB\u7EDF\u6A21\u5757",align:"center",prop:"title","show-overflow-tooltip":!0}),e(g,{label:"\u64CD\u4F5C\u7C7B\u578B",align:"center",prop:"businessType"},{default:l(o=>[e(O,{options:t(T),value:o.row.businessType},null,8,["options","value"])]),_:1}),e(g,{label:"\u64CD\u4F5C\u4EBA\u5458",align:"center",width:"110",prop:"operName","show-overflow-tooltip":!0,sortable:"custom","sort-orders":["descending","ascending"]}),e(g,{label:"\u4E3B\u673A",align:"center",prop:"operIp",width:"130","show-overflow-tooltip":!0}),e(g,{label:"\u64CD\u4F5C\u72B6\u6001",align:"center",prop:"status"},{default:l(o=>[e(O,{options:t(q),value:o.row.status},null,8,["options","value"])]),_:1}),e(g,{label:"\u64CD\u4F5C\u65E5\u671F",align:"center",prop:"operTime",width:"180",sortable:"custom","sort-orders":["descending","ascending"]},{default:l(o=>[I("span",null,i(r.parseTime(o.row.operTime)),1)]),_:1}),e(g,{label:"\u6D88\u8017\u65F6\u95F4",align:"center",prop:"costTime",width:"110","show-overflow-tooltip":!0,sortable:"custom","sort-orders":["descending","ascending"]},{default:l(o=>[I("span",null,i(o.row.costTime)+"\u6BEB\u79D2",1)]),_:1}),e(g,{label:"\u64CD\u4F5C",align:"center","class-name":"small-padding fixed-width"},{default:l(o=>[h((c(),b(y,{link:"",type:"primary",icon:"View",onClick:ke=>ee(o.row,o.index)},{default:l(()=>[d("\u8BE6\u7EC6")]),_:2},1032,["onClick"])),[[x,["monitor:operlog:query"]]])]),_:1})]),_:1},8,["data","default-sort"])),[[de,t(S)]]),h(e(re,{total:t(D),page:t(n).pageNum,"onUpdate:page":a[6]||(a[6]=o=>t(n).pageNum=o),limit:t(n).pageSize,"onUpdate:limit":a[7]||(a[7]=o=>t(n).pageSize=o),onPagination:v},null,8,["total","page","limit"]),[[j,t(D)>0]]),e(ue,{title:"\u64CD\u4F5C\u65E5\u5FD7\u8BE6\u7EC6",modelValue:t(w),"onUpdate:modelValue":a[9]||(a[9]=o=>$(w)?w.value=o:null),width:"700px","append-to-body":""},{footer:l(()=>[I("div",he,[e(y,{onClick:a[8]||(a[8]=o=>w.value=!1)},{default:l(()=>[d("\u5173 \u95ED")]),_:1})])]),default:l(()=>[e(z,{model:t(s),"label-width":"100px"},{default:l(()=>[e(F,null,{default:l(()=>[e(m,{span:12},{default:l(()=>[e(u,{label:"\u64CD\u4F5C\u6A21\u5757\uFF1A"},{default:l(()=>[d(i(t(s).title)+" / "+i(J(t(s))),1)]),_:1}),e(u,{label:"\u767B\u5F55\u4FE1\u606F\uFF1A"},{default:l(()=>[d(i(t(s).operName)+" / "+i(t(s).operIp)+" / "+i(t(s).operLocation),1)]),_:1})]),_:1}),e(m,{span:12},{default:l(()=>[e(u,{label:"\u8BF7\u6C42\u5730\u5740\uFF1A"},{default:l(()=>[d(i(t(s).operUrl),1)]),_:1}),e(u,{label:"\u8BF7\u6C42\u65B9\u5F0F\uFF1A"},{default:l(()=>[d(i(t(s).requestMethod),1)]),_:1})]),_:1}),e(m,{span:24},{default:l(()=>[e(u,{label:"\u64CD\u4F5C\u65B9\u6CD5\uFF1A"},{default:l(()=>[d(i(t(s).method),1)]),_:1})]),_:1}),e(m,{span:24},{default:l(()=>[e(u,{label:"\u8BF7\u6C42\u53C2\u6570\uFF1A"},{default:l(()=>[d(i(t(s).operParam),1)]),_:1})]),_:1}),e(m,{span:24},{default:l(()=>[e(u,{label:"\u8FD4\u56DE\u53C2\u6570\uFF1A"},{default:l(()=>[d(i(t(s).jsonResult),1)]),_:1})]),_:1}),e(m,{span:6},{default:l(()=>[e(u,{label:"\u64CD\u4F5C\u72B6\u6001\uFF1A"},{default:l(()=>[t(s).status===0?(c(),k("div",ve,"\u6B63\u5E38")):t(s).status===1?(c(),k("div",ye,"\u5931\u8D25")):A("",!0)]),_:1})]),_:1}),e(m,{span:8},{default:l(()=>[e(u,{label:"\u6D88\u8017\u65F6\u95F4\uFF1A"},{default:l(()=>[d(i(t(s).costTime)+"\u6BEB\u79D2",1)]),_:1})]),_:1}),e(m,{span:10},{default:l(()=>[e(u,{label:"\u64CD\u4F5C\u65F6\u95F4\uFF1A"},{default:l(()=>[d(i(r.parseTime(t(s).operTime)),1)]),_:1})]),_:1}),e(m,{span:24},{default:l(()=>[t(s).status===1?(c(),b(u,{key:0,label:"\u5F02\u5E38\u4FE1\u606F\uFF1A"},{default:l(()=>[d(i(t(s).errorMsg),1)]),_:1})):A("",!0)]),_:1})]),_:1})]),_:1},8,["model"])]),_:1},8,["modelValue"])])}}});export{Te as default};
