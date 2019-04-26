package com.yp.common.utils;


import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

public class FileUtils {
    //�ϴ�����ͼƬ,����·��
    public String UploadRoomPicture(MultipartFile multipartFile) {
        String fileName = multipartFile.getOriginalFilename();
        multipartFile.getContentType();
        String path = "D:/IdeaProjects/picture/";
        String roomPath = path + fileName;
        File files = new File(roomPath);
        try {
            multipartFile.transferTo(files);
            System.out.print("�ϴ��ɹ�");
        } catch (IOException e) {
            System.out.print("�ϴ�ʧ��");
            e.printStackTrace();
        }
        return roomPath;
    }

    //�ϴ���ͼƬ
    public String UplodeBuildingPicture(MultipartFile multipartFile) {
        String fileName = multipartFile.getOriginalFilename();
        multipartFile.getContentType();
        String path = "D:/IdeaProjects/picture/";
        String buildPath = path + fileName;
        File files = new File(buildPath);
        try {
            multipartFile.transferTo(files);
            System.out.print("�ϴ��ɹ�");
        } catch (IOException e) {
            System.out.print("�ϴ�ʧ��");
            e.printStackTrace();
        }
        return buildPath;
    }

    //�ϴ���԰��ͼƬ
    public String UploadSubparkPicture(MultipartFile multipartFile) {
        String fileName = multipartFile.getOriginalFilename();
        multipartFile.getContentType();
        String path = "D:/IdeaProjects/picture/";
        String subParkPath = path + fileName;
        File files = new File(subParkPath);
        try {
            multipartFile.transferTo(files);
            System.out.print("�ϴ��ɹ�");
        } catch (IOException e) {
            System.out.print("�ϴ�ʧ��");
            e.printStackTrace();
        }
        return subParkPath;
    }

    //�ϴ���԰��ͼƬ
    public String UploadGeneralPicture(MultipartFile multipartFile) {
        String fileName = multipartFile.getOriginalFilename();
        multipartFile.getContentType();
        String path = "D:/IdeaProjects/picture/";
        String generalPath = path + fileName;
        File files = new File(generalPath);
        try {
            multipartFile.transferTo(files);
            System.out.print("�ϴ��ɹ�");
        } catch (IOException e) {
            System.out.print("�ϴ�ʧ��");
            e.printStackTrace();
        }
        return generalPath;
    }

    //�ϴ������ļ��������ļ�·��
    public String UploadFile(MultipartFile file) {
        String fileName = file.getOriginalFilename();
        file.getContentType();
        String path = "D:/IdeaProjects/file/";
        String filePath = path + fileName;
        File files = new File(filePath);
        try {
            file.transferTo(files);
            System.out.print("�ϴ��ɹ�");
        } catch (IOException e) {
            System.out.print("�ϴ�ʧ��");
            e.printStackTrace();
        }
        return filePath;
    }

    //�ϴ�����ļ��������ļ�·������
    public List<String> UploadFiles(MultipartFile[] multipartFiles) throws IOException {
        List<File> list = new ArrayList<File>();
        List<String> slist = new ArrayList<String>();
        File file = null;
        String filesPath;
        String path = "D:/IdeaProjects/file/";
        for (int i = 0; i < multipartFiles.length; i++) {
            String name = multipartFiles[i].getOriginalFilename();
            filesPath = path + name;
            file = new File(filesPath);
            multipartFiles[i].transferTo(file);
            slist.add(filesPath);
        }
        return slist;
    }

    public String downFile(String fileName, String path, HttpServletResponse response) {

        try {
            fileName = new String(fileName.getBytes("iso8859-1"), "UTF-8");

            String name = fileName + ".xlsx";
//             // ��ȡ�ϴ��ļ���Ŀ¼
//            ServletContext sc = request.getSession().getServletContext();
//            System.out.println("4");
//            // �ϴ�λ��
//            String fileSaveRootPath = sc.getRealPath("/img");
//
//            System.out.println(fileSaveRootPath + "\\" + fileName);
            // �õ�Ҫ���ص��ļ�
            File file = new File(path);

            // ����ļ�������
            if (!file.exists()) {
                System.out.println("��Ҫ���ص���Դ�ѱ�ɾ������");
                return "error";
            }
            // �����ļ���
            String realname = name.substring(fileName.indexOf("_") + 1);
            // ������Ӧͷ��������������ظ��ļ�
            response.setHeader("content-disposition", "attachment;filename="
                    + URLEncoder.encode(realname, "UTF-8"));
            // ��ȡҪ���ص��ļ������浽�ļ�������
            FileInputStream in = new FileInputStream(path + "\\" + fileName);
            // ���������
            OutputStream out = response.getOutputStream();
            // ����������
            byte buffer[] = new byte[1024];
            int len = 0;
            // ѭ�����������е����ݶ�ȡ������������
            while ((len = in.read(buffer)) > 0) {
                // ��������������ݵ��������ʵ���ļ�����
                out.write(buffer, 0, len);
            }
            // �ر��ļ�������
            in.close();
            // �ر������
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "success";
    }

}
