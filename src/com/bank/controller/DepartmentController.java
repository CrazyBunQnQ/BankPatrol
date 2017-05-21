package com.bank.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bank.entity.Department;
import com.bank.entity.PageInfo;
import com.bank.service.DepartmentService;
import com.bank.service.impl.DepartmentServiceImpl;

public class DepartmentController {
	//创建对象
	DepartmentService deptService = new DepartmentServiceImpl();
	public void deptList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		//判断是否显示搜索区内容
		String hiddenFind = request.getParameter("hiddenFind") == null ? "hidden" : request.getParameter("hiddenFind");
		//把是否显示搜索内容放到request域中，并取名为hiddenFind
		request.setAttribute("hiddenFind", hiddenFind);
		//拿到当前页
		int page = Integer.parseInt(request.getParameter("curpage") == null ? "1" : request.getParameter("curpage"));
		//拿到模糊查询的搜索条件
		String name = request.getParameter("searchDeptName");
		//把模糊搜索的条件放到request域中并取名为name
		request.setAttribute("searchDeptname", name);
		//创建部门分页对象，并给对象赋值
		PageInfo<Department> data = deptService.queryDepart(page, (String)request.getAttribute("searchDeptname"));
		//将查出的值放入request域中并取名为data
		request.setAttribute("data", data);
		//转发页面到/jsp/system/dept/deptList.jsp
		request.getRequestDispatcher("/jsp/system/dept/deptList.jsp").forward(request, response);
	}
	
	public void toDeptAdd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//转发页面到/jsp/system/dept/deptNew.jsp
		request.getRequestDispatcher("/jsp/system/dept/deptNew.jsp").forward(request, response);
	}

	public void checkDeptName(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException {
		//拿到查询的搜索条件name
		String deptName = request.getParameter("name");
		//判断部门是否存在
		if(deptService.hasDept(deptName)){
			//存在则给前台响应一个为0的值
			response.getWriter().write("0");
		}else{
			//不存在给前台响应一个为1的值
			response.getWriter().write("1");
		};
	}

	public void deptAdd(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException {
		//拿到查询的搜索条件departmentName
		String name = request.getParameter("departmentName");
		//判断添加是否成功
		if(deptService.addDepartment(name)){
			//重定向到/Bank/dept/deptList
			response.sendRedirect("/Bank/dept/deptList");
		}
	}

	public void deptDelete(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException{
		//拿到查询的搜索条件deptId
		int depId = Integer.parseInt(request.getParameter("deptId"));
		//存在则重定向到/Bank/dept/deptList
		if(deptService.deleteDepartment(depId)){
			response.sendRedirect("/Bank/dept/deptList");
		}
	}

	public void dept2Update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		//拿到查询的搜索条件deptId
		int id = Integer.parseInt(request.getParameter("deptId"));
		//创建部门对象并根据id拿到部门对象
		Department dept = deptService.getDeptById(id);
		//将查出的值放入request域中并取名为dept
		request.setAttribute("dept", dept);
		//转发页面到/jsp/system/dept/deptUpdate.jsp
		request.getRequestDispatcher("/jsp/system/dept/deptUpdate.jsp").forward(request, response);	
	}

	public void deptUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		//拿到查询的搜索条件department_id
		int id = Integer.parseInt(request.getParameter("department_id"));
		//拿到查询的搜索条件departmentName
		String name = request.getParameter("departmentName");
		//创建对象
		Department dept = new Department();
		//给部门赋值
		dept.setId(id);
		dept.setName(name);
		//判断是否更新成功，成功则重定向到/Bank/dept/deptList
		if(deptService.updateDepartment(dept)){
			response.sendRedirect("/Bank/dept/deptList");
		}
		
	}
	/**
	 * 方法过期 不建议使用
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	@Deprecated
	public void deptQueryList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		int page = Integer.parseInt(request.getParameter("curpage") == null ? "1" : request.getParameter("curpage"));
		String name = request.getParameter("searchDeptName");
		request.setAttribute("searchDeptName", name);
		PageInfo<Department> data = deptService.queryDepartByCondition(page,(String)request.getAttribute("searchDeptName"));
		request.setAttribute("data", data);
		request.getRequestDispatcher("/jsp/system/dept/deptList.jsp").forward(request, response);
	}
	
}
