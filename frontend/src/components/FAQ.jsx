import React from "react";
import { MDBAccordion, MDBAccordionItem, MDBContainer } from "mdb-react-ui-kit";

export default function App() {
    return (
        <MDBContainer className="mt-5 mb-5" style={{maxWidth: '1500px'}}>
            <MDBAccordion alwaysOpen initialActive={1}>
                <MDBAccordionItem collapseId={1} headerTitle="What payment methods do you accept?">
                    <strong>At FlexDrone </strong> We accept Visa/Mastercard credit and debit cards as well as PayPal.

                </MDBAccordionItem>
                <MDBAccordionItem collapseId={2} headerTitle="What is your return policy?">
                    Each product has it's own warranty period that varies in length depending on the product.
                    Drones and drone parts and covered by the manufacturer we source from. Therefore, if your part or drone is faulty as a result
                    of its manufacture and within the product's warranty-period, then you can send it back to us; so that we can send it off to the manufacturer
                    for either repair or replacement. From the time we send your product to the manufacture to the time that we receive it or it's replacement back,
                    usually varies between 6 - 12 business days. The costs you take on to send it to us - provided the product is faulty from manufacture and within
                    it's warranty period - we will reimburse you for.
                </MDBAccordionItem>
                <MDBAccordionItem collapseId={3} headerTitle="What is your refund policy?">
                    All products faulty from manufacture are offered the opportunity for a full refund within a 30-day time period from
                </MDBAccordionItem>
            </MDBAccordion>
        </MDBContainer>
    );
}