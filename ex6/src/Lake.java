import java.util.ArrayList;
import java.util.List;

public class Lake extends Element {

    // composite design pattern
    private List<Element> elements;
    private String name;
    public Lake(String name, double diameter, String path) {
        super(diameter,diameter,path);
        this.name = name;
        elements = new ArrayList<Element>();
    }

    public void addElement(Element element) {
        if (element.getHabitat() == Habitat.AQUATIC || element.getHabitat() == Habitat.AMPHIBIAN) {
            elements.add(element);
        } else {
            System.out.println(getName() + " cannot contain " + element.getName());
        }
    }

    public void accept(Visitor visitor) {
        // visitor design pattern
        visitor.visit(this);
        for (Element element : elements) {
            element.accept(visitor);
        }
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Habitat getHabitat() {
        return Habitat.TERRESTRIAL;
    }

    public boolean isEmpty() {
        return elements.isEmpty();
    }
}
