#include <string>
#include <algorithm>
#include <iostream>

int main(){
        std::string s;
        std::cin >> s;
        size_t turns;
        std::cin >> turns;
        std::string::iterator exc,pos2;
        for(size_t pos=0;pos!=s.size() && turns;++pos){
                pos2=s.begin()+pos;
                exc=std::min_element(pos2,s.begin()+std::min(pos+turns+1,s.size()));
                        //Hitta ett element som passar bättre, inom den radien vi har
                turns-=size_t(std::distance(pos2,exc));
                std::rotate(pos2,exc,exc+1);
                        //Förenkling av framflyttningen ger rotation, även om det troligtvis inte är den mest tidseffektiva lösningen
        }
        std::cout << s << std::endl;
        return 0;
}
