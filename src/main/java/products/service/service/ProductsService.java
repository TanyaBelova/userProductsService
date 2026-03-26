package products.service.service;

import products.service.model.entity.Product;
import products.service.model.entity.UserProductRelations;

import java.util.List;
import java.util.UUID;

public interface ProductsService {

    /**
     * Создает новую услугу
     */
    Product create(String name);

    /**
     * Возвращает список всех имеющихся АКТИВНЫХ услуг
     * @return список АКТИВНЫХ услуг
     */
    List<Product> readActive();

    /**
     * Возвращает список всех имеющихся у пользователя АКТИВНЫХ услуг
     * @return список АКТИВНЫХ услуг пользователя
     */
    List<Product> readActive(UUID userId);

    /**
     * Создает связь пользователя с услугой
     */
    boolean createRelation(UserProductRelations userProductRelations);

    /**
     * Обновляет активность переданной услуги
     * @param id - id услуги, которую нужно обновить
     * @return - true если данные были обновлены, иначе false
     */
    boolean updateActivity(UUID id, boolean active);


    /**
     * Удаляет услугу с заданным ID
     * @param id - id услуги, которую нужно удалить
     * @return - true если услуга был удалена, иначе false
     */
    boolean delete(UUID id);

    /**
     * Удвляет связь пользователя с услугой
     */
    boolean deleteRelation(UUID id);

}
