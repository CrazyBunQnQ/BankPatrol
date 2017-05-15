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

	DepartmentService deptService = new DepartmentServiceImpl();
	
	public void deptList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		int page = Integer.parseInt(request.getParameter("curpage") == null ? "1" : request.getParameter("curpage"));
		String name = request.getParameter("searchDeptName");
		request.setAttribute("searchDeptname", name);
		PageInfo<Department> data = deptService.queryDepart(page, (String)request.getAttribute("searchDeptname"));
		request.setAttribute("data", data);
		request.getRequestDispatcher("/jsp/system/dept/deptList.jsp").forward(request, response);
	}

	public void toDeptAdd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/jsp/system/dept/deptNew.jsp").forward(request, response);
	}

	public void checkDeptName(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException {
		String deptName = request.getParameter("name");
		if(deptService.hasDept(deptName)){
			response.getWriter().write("0");
		}else{
			response.getWriter().write("1");
		};
	}

	public void deptAdd(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException {
		String name = request.getParameter("departmentName");
		if(deptService.addDepartment(name)){
			System.out.println(11);
			response.sendRedirect("/Bank/dept/deptList.do");
		}
		
	}

	public void deptDelete(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException{
		int depId = Integer.parseInt(request.getParameter("deptId"));
		if(deptService.deleteDepartment(depId)){
			response.sendRedirect("/Bank/dept/deptList.do");
		}
	}

	public void dept2Update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		int id = Integer.parseInt(request.getParameter("deptId"));
		Department dept = deptService.getDeptById(id);
		request.setAttribute("dept", dept);
		request.getRequestDispatcher("/jsp/system/dept/deptUpdate.jsp").forward(request, response);	
	}

	public void deptUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		int id = Integer.parseInt(request.getParameter("department_id"));
		String name = request.getParameter("departmentName");
		Department dept = new Department();
		dept.setId(id);
		dept.setName(name);
		if(deptService.updateDepartment(dept)){
			response.sendRedirect("/Bank/dept/deptList.do");
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
