package dataSet.LKL.POL;

import lombok.*;

@Getter
@RequiredArgsConstructor

public class DataPOL {
    private final DataPOLdoc document = null;


    private final int id;
    private final String validation_period;
    private final String basis_doc_type;

//    public DocumentService(int docId) {
//        this.document = document.getById(docId); // Поиск документа по ID
//    }

}
