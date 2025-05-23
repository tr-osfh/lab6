package seClasses;


import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

/**
 * Класс Dragon представляет дракона с набором характеристик.
 * Включает такие поля, как имя, координаты, возраст, описание, вес, тип и убийца.
 */
public class Dragon implements Comparable<Dragon>, Serializable {

    @Serial
    private static final long serialVersionUID = 32L;

    private long id; // Уникальный идентификатор дракона, должен быть больше 0
    private String name; // Имя дракона, не может быть null или пустым
    private Coordinates coordinates; // Координаты дракона, не могут быть null
    private LocalDateTime creationDate = LocalDateTime.now(); // Дата создания, генерируется автоматически
    private Long age; // Возраст дракона, должен быть больше 0, может быть null
    private String description; // Описание дракона, может быть null
    private Long weight; // Вес дракона, должен быть больше 0, может быть null
    private DragonType type; // Тип дракона, не может быть null
    private Person killer; // Убийца дракона, может быть null

    /**
     * Конструктор для создания объекта Dragon с убийцей.
     * @param name Имя дракона.
     * @param coordinates Координаты дракона.
     * @param age Возраст дракона.
     * @param description Описание дракона.
     * @param weight Вес дракона.
     * @param type Тип дракона.
     * @param killer Убийца дракона.
     * @throws IllegalArgumentException Если переданы некорректные значения.
     */
    public Dragon(
            String name,
            Coordinates coordinates,
            Long age,
            String description,
            Long weight,
            DragonType type,
            Person killer
    ) {
        if (name == null || name.isEmpty() || coordinates == null || (age != null && age <= 0) || (weight !=null && weight <= 0) || type == null) {
            throw new IllegalArgumentException("Введенная информация содержит недопустимые значения.");
        } else {
            this.name = name;
            this.coordinates = coordinates;
            this.age = age;
            this.description = description;
            this.weight = weight;
            this.type = type;
            this.killer = killer;
        }
    }

    /**
     * Конструктор для создания объекта Dragon без убийцы.
     * @param name Имя дракона.
     * @param coordinates Координаты дракона.
     * @param age Возраст дракона.
     * @param description Описание дракона.
     * @param weight Вес дракона.
     * @param type Тип дракона.
     * @throws IllegalArgumentException Если переданы некорректные значения.
     */
    public Dragon(
            String name,
            Coordinates coordinates,
            Long age,
            String description,
            Long weight,
            DragonType type
    ) {
        if (name == null || name.isEmpty() || (weight != null && weight <= 0) || coordinates == null || (age != null && age <= 0) || type == null) {
            throw new IllegalArgumentException("В исходном файле ошибка.");
        } else {
            this.name = name;
            this.coordinates = coordinates;
            this.age = age;
            this.description = description;
            this.weight = weight;
            this.type = type;
        }
    }

    /**
     * Возвращает идентификатор дракона.
     * @return Идентификатор дракона.
     */
    public long getId() {
        return id;
    }

    /**
     * Устанавливает идентификатор дракона.
     * @param id Идентификатор дракона.
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * Возвращает имя дракона.
     * @return Имя дракона.
     */
    public String getName() {
        return name;
    }

    /**
     * Устанавливает имя дракона.
     * @param name Имя дракона.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Возвращает координаты дракона.
     * @return Координаты дракона.
     */
    public Coordinates getCoordinates() {
        return coordinates;
    }

    /**
     * Устанавливает координаты дракона.
     * @param coordinates Координаты дракона.
     */
    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    /**
     * Возвращает дату создания дракона.
     * @return Дата создания дракона.
     */
    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    /**
     * Устанавливает дату создания дракона.
     * @param creationDate Дата создания дракона.
     */
    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    /**
     * Возвращает возраст дракона.
     * @return Возраст дракона.
     */
    public Long getAge() {
        return age;
    }

    /**
     * Устанавливает возраст дракона.
     * @param age Возраст дракона.
     */
    public void setAge(Long age) {
        this.age = age;
    }

    /**
     * Возвращает описание дракона.
     * @return Описание дракона.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Устанавливает описание дракона.
     * @param description Описание дракона.
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Возвращает вес дракона.
     * @return Вес дракона.
     */
    public Long getWeight() {
        return weight;
    }

    /**
     * Устанавливает вес дракона.
     * @param weight Вес дракона.
     */
    public void setWeight(Long weight) {
        this.weight = weight;
    }

    /**
     * Возвращает тип дракона.
     * @return Тип дракона.
     */
    public DragonType getType() {
        return type;
    }

    /**
     * Устанавливает тип дракона.
     * @param type Тип дракона.
     */
    public void setType(DragonType type) {
        this.type = type;
    }

    /**
     * Возвращает убийцу дракона.
     * @return Убийца дракона.
     */
    public Person getKiller() {
        return killer;
    }

    /**
     * Устанавливает убийцу дракона.
     * @param killer Убийца дракона.
     */
    public void setKiller(Person killer) {
        this.killer = killer;
    }

    /**
     * Сравнивает текущий объект с другим объектом на равенство.
     * @param object Объект для сравнения.
     * @return true, если объекты равны, иначе false.
     */
    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Dragon dragon = (Dragon) object;
        return id == dragon.id &&
                Objects.equals(name, dragon.name) &&
                Objects.equals(coordinates, dragon.coordinates) &&
                Objects.equals(creationDate, dragon.creationDate) &&
                Objects.equals(age, dragon.age) &&
                Objects.equals(description, dragon.description) &&
                Objects.equals(weight, dragon.weight) &&
                type == dragon.type &&
                Objects.equals(killer, dragon.killer);
    }

    /**
     * Возвращает хэш-код объекта Dragon.
     * @return Хэш-код объекта.
     */
    @Override
    public int hashCode() {
        return Objects.hash(id, name, coordinates, creationDate, age, description, weight, type, killer);
    }

    /**
     * Возвращает строковое представление объекта Dragon.
     * @return Строка, представляющая объект Dragon.
     */
    @Override
    public String toString() {
        return "Dragon{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", coordinates=" + coordinates +
                ", creationDate=" + creationDate +
                ", age=" + age +
                ", description='" + description + '\'' +
                ", weight=" + weight +
                ", type=" + type +
                ", killer=" + killer +
                '}';
    }

    /**
     * Сравнивает текущий объект Dragon с другим объектом Dragon по координате X.
     * @param o Объект Dragon для сравнения.
     * @return 1, если текущий объект больше, -1, если меньше, и 0, если равны.
     */
    @Override
    public int compareTo(Dragon o) {
        if (this.getCoordinates().getX() > o.getCoordinates().getX()) {
            return 1;
        } else if (this.getCoordinates().getX() < o.getCoordinates().getX()) {
            return -1;
        } else {
            return 0;
        }
    }
}