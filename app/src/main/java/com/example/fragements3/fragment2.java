package com.example.fragements3;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.appcompat.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class fragment2 extends Fragment {

    private View view;
    private ListView listView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_fragment2, container, false);
        listView = view.findViewById(R.id.list_view);



        // Set up the data for the ListView
        String[] titles = {"Brasil", "Canadá", "Noruega", "Polônia"};
        String[] descriptions = {"O Brasil é um país com enorme potencial turístico em razão da diversidade cultural e," +
                " principalmente, das belezas naturais do imenso território, mas esse potencial ainda não é explorando em sua totalidade.\n"

                ,"As vastas regiões de natureza selvagem do Canadá compreendem o Parque Nacional de Banff, repleto de lagos nas Montanhas" +
                " Rochosas. Abriga também as Cataratas do Niágara, um famoso conjunto de enormes cachoeiras",

                "A Noruega é um país escandinavo que abrange montanhas, geleiras e fiordes litorâneos profundos. " +
                        "Oslo, a capital, é uma cidade cheia de áreas verdes e museus. Navios vikings preservados do" +
                        " século IX são exibidos no Museu do Navio Viking de Oslo. Bergen, com suas casas coloridas de madeira," +
                        " é o ponto de partida de cruzeiros rumo ao deslumbrante Fiorde de Sogn",

                "A Polônia é um país do Leste Europeu na costa do Mar Báltico, conhecido por sua arquitetura medieval e pela herança" +
                        " judaica. Na cidade de Cracóvia, o Castelo de Wawel, construído no século XIV, eleva-se sobre a antiga cidade" +
                        " medieval, que abriga o Cloth Hall, um entreposto comercial renascentista na Rynek Glówny (praça do mercado)." +
                        " Nas proximidades, está localizado o memorial do campo de concentração de Auschwitz-Birkenau, além da vasta" +
                        " Mina de Sal de Wieliczka",

               };


        List<Item> items = new ArrayList<>();
        for (int i = 0; i < titles.length; i++) {
            Item item = new Item(titles[i], descriptions[i]);
            items.add(item);
        }

        ArrayAdapter<Item> adapter = new ArrayAdapter<Item>(getContext(), R.layout.list_item, items) {
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                if (convertView == null) {
                    convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
                }

                Item item = getItem(position);

                TextView titleTextView = convertView.findViewById(R.id.text_title);
                TextView descriptionTextView = convertView.findViewById(R.id.text_description);

                titleTextView.setText(item.getTitle());
                descriptionTextView.setText(item.getDescription());

                return convertView;
            }
        };

        listView.setAdapter(adapter);

        // Set click listener for ListView items
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Item selectedItem = (Item) parent.getItemAtPosition(position);
                if (selectedItem.getTitle().equals("Item 1")) {

                    Intent intent = new Intent(getActivity(), item1.class);
                    startActivity(intent);
                }
            }
        });

        return view;
    }

    private static class Item {
        private String title;
        private String description;

        public Item(String title, String description) {
            this.title = title;
            this.description = description;
        }

        public String getTitle() {
            return title;
        }

        public String getDescription() {
            return description;
        }
    }
}