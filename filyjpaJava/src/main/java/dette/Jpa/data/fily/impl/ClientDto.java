package dette.Jpa.data.fily.impl;

import java.util.List;

import dette.Jpa.data.entities.Client;
import dette.Jpa.data.fily.DtoInterface;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ClientDto implements DtoInterface<Client, ClientDto> {

    private int id;
    private String surname;
    private String telephone;
    private String adresse;
    private UserDto user;

    @Builder
    public ClientDto() {

    }

    @Builder
    public ClientDto(Client client) {
        toDto(client);
    }

    @Override
    public ClientDto toDto(Client data) {
        // System.out.println(data.getUser() != null);
        return ClientDto.builder()
                .id(data.getId())
                .adresse(data.getAdresse())
                .telephone(data.getTelephone())
                .user(data.getUser() == null ? null : new UserDto(data.getUser()))
                .build();
    }

    @Override
    public List<ClientDto> toListDto(List<Client> list) {
        return list.stream()
                .map(this::toDto)
                .toList();
    }

}
