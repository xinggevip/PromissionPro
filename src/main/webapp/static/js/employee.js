$(function(){
    $("#dg").datagrid({
        url:"/employeeList",
        columns:[[
            {field:'username',title:'姓名',width:100,algin:'center'},
            {field:'inputtime',title:'入职时间',width:100,algin:'center'},
            {field:'tel',title:'电话',width:100,algin:'center'},
            {field:'email',title:'邮箱',width:100,algin:'center'},
            {field:'department',title:'部门',width:100,algin:'center'},
            {field:'state',title:'状态',width:100,algin:'center'},
        ]],
        fit:true,
        fitColumns:true,
        rownumbers:true,
        pagination:true
    });

});