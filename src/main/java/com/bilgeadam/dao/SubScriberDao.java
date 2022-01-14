package com.bilgeadam.dao;

import com.bilgeadam.dto.SubScriberDto;
import lombok.extern.log4j.Log4j2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

@Log4j2
public class SubScriberDao implements IDaoConnection <SubScriberDto> {
    @Override
    public void create(SubScriberDto subScriberDto) {
        try (Connection connection = getInterfaceConnection()) {
            String sql = "insert into subscriber (subscriber_name,subscriber_surname,subscriber_address,subscriber_email_address) values(?,?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, subScriberDto.getSubScriberName());
            preparedStatement.setString(2, subScriberDto.getSubScriberSurname());
            preparedStatement.setString(3, subScriberDto.getSubScriberAddress());
            preparedStatement.setString(4, subScriberDto.getSubScriberEmailAddress());
            int rowEffected = preparedStatement.executeUpdate();
            if (rowEffected > 0) {
                log.info(SubScriberDao.class + " Ekleme başarılı");
            } else {
                System.out.println("Ekleme sırasında bir hata meydana geldi");
                log.error(SubScriberDao.class + " Ekleme sırasında bir hata meydana geldi");
            }
        } catch (SQLException e) {
            log.error(e.getMessage() + " AdminDao insert Hata meydana geldi  ");
            e.printStackTrace();
        }
    }

    @Override
    public void update(SubScriberDto subScriberDto) {
        try (Connection connection2 = getInterfaceConnection()) {
            String sql2 = "update  subscriber set subscriber_name=?,subscriber_surname=?,subscriber_address=?,subscriber_email_address=? where subscriber_id=?";
            PreparedStatement preparedStatement2 = connection2.prepareStatement(sql2);
            preparedStatement2.setString(1, subScriberDto.getSubScriberName());
            preparedStatement2.setString(2, subScriberDto.getSubScriberSurname());
            preparedStatement2.setString(3, subScriberDto.getSubScriberAddress());
            preparedStatement2.setString(4, subScriberDto.getSubScriberEmailAddress());
            int rowEffected = preparedStatement2.executeUpdate();
            if (rowEffected > 0) {
                log.info(SubScriberDao.class + " Ekleme başarılı");
            } else {
                log.error(SubScriberDao.class + " Ekleme sırasında bir hata meydana geldi");
            }
        } catch (SQLException e) {
            log.error(e.getMessage() + " AdminDao insert Hata meydana geldi  ");
            e.printStackTrace();
        }
    }

    @Override
    public void delete(SubScriberDto subScriberDto) {
        try (Connection connection = getInterfaceConnection()) {
            String sql = "delete from  subscriber where subscriber_id=? ";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, subScriberDto.getSubScriberId());
            int rowEffected = preparedStatement.executeUpdate();
            if (rowEffected > 0) {
                log.info(SubScriberDao.class + " Silme başarılı");
            } else {
                log.error(SubScriberDao.class + " Silme sırasında bir hata meydana geldi");
            }
        } catch (SQLException e) {
            log.error(e.getMessage() + " SubScriberDao Delete Hata meydana geldi  ");
            e.printStackTrace();
        }
    }

    @Override
    public ArrayList<SubScriberDto> list() {
        ArrayList<SubScriberDto> list2 = new ArrayList<SubScriberDto>();
        SubScriberDto subScriberDto;
        try (Connection connection = getInterfaceConnection()) {
            String sql = "select * from admin_blog";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                subScriberDto = new SubScriberDto();
                subScriberDto.setSubScriberId(resultSet.getInt("subscriber_id"));
                subScriberDto.setSubScriberName(resultSet.getString("subscriber_name"));
                subScriberDto.setSubScriberSurname(resultSet.getString("subscriber_surname"));
                subScriberDto.setSubScriberAddress(resultSet.getString("subscriber_address"));
                subScriberDto.setSubScriberEmailAddress(resultSet.getString("subscriber_email_address"));
                list2.add(subScriberDto);
            }
        } catch (SQLException e) {
            log.error(e.getMessage() + " SubScriberDao Listeleme sırasında Hata meydana geldi  ");
            e.printStackTrace();
        }
        return list2;
    }
}

