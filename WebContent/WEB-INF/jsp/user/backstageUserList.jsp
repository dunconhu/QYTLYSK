<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
	<title>后台管理员</title>
    <meta name="description" content="这是一个 jsp页面">
    <meta name="keywords" content="index">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="renderer" content="webkit">
    <meta http-equiv="Cache-Control" content="no-siteapp" />
    <link rel="icon" type="image/png" href="i/favicon.png">
    <link rel="apple-touch-icon-precomposed" href="i/app-icon72x72@2x.png">
    <meta name="apple-mobile-web-app-title" content="Amaze UI" />
    <link rel="stylesheet" href="${pageContext.request.contextPath }/css/amazeui.min.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath }/css/app.css">

   
</head>
<body>
            <!-- 内容区域 -->
            <div class="row-content am-cf">
                <div class="row">
                    <div class="am-u-sm-12 am-u-md-12 am-u-lg-12">
                        <div class="widget am-cf">
                            <div class="widget-head am-cf">
                                <div class="widget-title  am-cf" style="color:#5C5C5C">管理员列表</div>


                            </div>
                            <div class="widget-body  am-fr">

                                <div class="am-u-sm-12 am-u-md-6 am-u-lg-6">
                                    <div class="am-form-group">
                                        <div class="am-btn-toolbar">
                                            <div class="am-btn-group am-btn-group-xs">
                                                <button type="button" class="am-btn am-btn-default am-btn-success"><span class="am-icon-plus"></span> 新增</button>                                               
                                                <button type="button" class="am-btn am-btn-default am-btn-danger"><span class="am-icon-trash-o"></span> 批量删除</button>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="am-u-sm-12 am-u-md-6 am-u-lg-3">
                                    <div class="am-form-group tpl-table-list-select">
                                        <select data-am-selected="{btnSize: 'sm'}">
								              <option value="strLoginName">管理员账号</option>
								              <option value="strRealName">管理员姓名</option>
								              <option value="intStatus">状态</option>
								              <option value="dateCreateTime">注册时间</option>
								            </select>
                                    </div>
                                </div>
                                <div class="am-u-sm-12 am-u-md-12 am-u-lg-3">
                                    <div class="am-input-group am-input-group-sm tpl-form-border-form cl-p">
                                        <input type="text" class="am-form-field ">
                                        <span class="am-input-group-btn">
            <button class="am-btn  am-btn-default am-btn-success tpl-table-list-field am-icon-search" type="button"></button>
          </span>
                                    </div>
                                </div>

                                <div class="am-u-sm-12">
                                    <table style="width:100%" class="am-table am-table-compact am-table-striped tpl-table-black " id="example-r" >
                                        <thead>
                                            <tr style="color:#5C5C5C">
                                            	<th class="table-check"><input type="checkbox" /></th>
                                                <th>管理员账号</th>
                                                <th>管理员姓名</th>
                                                <th>状态</th>
                                                <th>创建时间</th>
                                                <th>操作</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                       	 <s:iterator value="backstageUserList">
                                            <tr class="gradeX">
                                           		<td><input type="checkbox" name="selectedRow" value="<s:property value='intId'/>"/></td>
                                                <td><s:property value="strLoginName"/></td>
                                                <td><s:property value="strRealName"/></td>
                                                <td><s:property value="intStatus?'启用':'未启用'"/></td>
                                                <td><s:property value="dateCreateTime"/></td>
                                                <td>
                                                    <div class="tpl-table-black-operation">
                                                        <a href="javascript:;">
                                                            <i class="am-icon-pencil"></i> 编辑
                                                        </a>
                                                        <a href="javascript:;" class="tpl-table-black-operation-del">
                                                            <i class="am-icon-trash"></i> 删除
                                                        </a>
                                                    </div>
                                                </td>
                                            </tr>
                                           </s:iterator>

                                          <!-- more data -->
                                        </tbody>
                                    </table>
                                </div>
                                <div class="am-u-lg-12 am-cf">
                                 <span style="color:#5C5C5C" id="total"></span>
                                    <div class="am-fr">
                                        <ul class="am-pagination tpl-pagination">
                                            <li class="am-disabled"><a href="#">«</a></li>
                                            <li class="am-active"><a href="#">1</a></li>
                                            <li><a href="#">2</a></li>
                                            <li><a href="#">3</a></li>
                                            <li><a href="#">4</a></li>
                                            <li><a href="#">5</a></li>
                                            <li><a href="#">»</a></li>
                                        </ul>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>    
</body>
<script src="${pageContext.request.contextPath }/js/jquery.min.js"></script>
<script type="text/javascript">
		ddd();
	   function ddd(){
	   	$.ajax({
	              url : "${pageContext.request.contextPath }/user/paginationFun",
	              type : "POST",
	              dataType:"json",
	              contentType : "application/json;charset=UTF-8",
	              /* 向后端传输的数据 */
	              data : JSON.stringify({
	                  
	              }),
	              success:function(result) {
	                  /* 处理后端返回的数据 */
	                  var mag = JSON.stringify(result);
	                  alert(mag);
	              	$("#total").html("共"+result.total+"条数据");
	              },
	              error:function(result){
	                  alert("意外的查询错误！");
	              }
	          });
	   };
  
    	//全选、全反选
		function doSelectAll(){
			// jquery 1.6 前
			//$("input[name=selectedRow]").attr("checked", $("#selAll").is(":checked"));
			//prop jquery 1.6+建议使用
			$("input[name=selectedRow]").prop("checked", $("#selAll").is(":checked"));		
		}
		//跳转添加页面
		function doAdd(){
			document.forms[0].action = "${basePath}nsfw/user_addUI.action";
			document.forms[0].submit();
		}
		//跳转编辑页面
		function doEdit(id){
			document.forms[0].action = "${basePath}nsfw/user_editUI.action?user.id=" + id;
			document.forms[0].submit();
		}
		//单条记录删除
		function doDelete(id){
			document.forms[0].action = "${basePath}nsfw/user_delete.action?user.id=" + id;
			document.forms[0].submit();
		}
		//批量删除
		function doDeleteAll(){
			document.forms[0].action = "${basePath}nsfw/user_deleteSelected.action";
			document.forms[0].submit();
		}
		//用户列表导出
		function doExportExcel(){
			document.forms[0].action = "${basePath}nsfw/user_exportUserList.action";
			document.forms[0].submit();
		}
		//用户信息导入
		function doImportExcel(){
			document.forms[0].action = "${basePath}nsfw/user_importExcel.action";
			document.forms[0].submit();
		}
  </script>
</html>