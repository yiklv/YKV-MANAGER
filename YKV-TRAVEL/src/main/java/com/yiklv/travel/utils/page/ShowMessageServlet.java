package com.yiklv.travel.utils.page;
import javax.servlet.http.HttpServlet;

public class ShowMessageServlet extends HttpServlet{

    /**
     * 
     */
    private static final long serialVersionUID = 6646899131087204214L;

   /* @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        doGet(req, resp);
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=utf-8");
        int pageIndex=0;
//        MessageDao md=new MessageDaoImpl();
        String pageIndexStr=req.getParameter("pageIndex");
        if(pageIndexStr!=null){
            try{
                pageIndex=Integer.parseInt(pageIndexStr);
            }catch (Exception e) {
            }
        }
        PageBean<Message> pb=new PageBean<Message>(pageIndex,md.getMessageCount(),10);
        pb.init();
        pb.setList(md.getMessageListOfPage(pb.getStart(), pb.getEnd()));
        req.setAttribute("pagebean", pb);
        req.getRequestDispatcher("index.jsp").forward(req, resp);
    }*/
}