package guru.springframework.fauxspring;

import guru.springframework.sfgpetclinic.fauxspring.Model;

import java.util.HashMap;

public class ModelMapImpl implements Model {
    HashMap<String, Object> models = new HashMap<>();
    @Override
    public void addAttribute(String key, Object o) {
        models.put(key, o);
    }

    @Override
    public void addAttribute(Object o) {

    }

    @Override
    public Object getAttribute(String key) {
        return models.get(key);
    }
}
